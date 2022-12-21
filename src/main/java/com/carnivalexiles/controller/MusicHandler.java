package com.carnivalexiles.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicHandler {

    //fields
    private static boolean music = true;
    private static Clip clip;


    public static boolean isMusic() {
        return music;
    }

    public static boolean setMusic(boolean music) {
        MusicHandler.music = music;
        return music;
    }

    public MusicHandler() {
    }

    public static void music() throws LineUnavailableException {
        if (music) {
            try {
                URL musicStream = MusicHandler.class.getClassLoader()
                        .getResource("island-beach.wav");
                if (musicStream == null) {
                    throw new IllegalArgumentException("file not found");
                }
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(musicStream);
                clip = AudioSystem.getClip();
                clip.open(inputStream);

                FloatControl gainControl = (FloatControl) clip.getControl(
                        FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-25.0f); // Reduce volume by 20 decibels.
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
        }
        if (setMusic(false)) {
            clip.stop();
        }
    }

    private static InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = MusicHandler.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }
}
