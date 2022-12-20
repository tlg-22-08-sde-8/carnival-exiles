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

  public static void music(String userInput) throws LineUnavailableException {
    Clip clip = AudioSystem.getClip();
    if (userInput.contains("music on")) {
      try {
        URL musicStream = MusicHandler.class.getClassLoader().getResource("island-beach.wav");
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(musicStream);
//        Clip clip = AudioSystem.getClip();
        clip.open(inputStream);

        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
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
    else if (userInput.contains("music off")) {
//      Clip clip = AudioSystem.getClip();
      clip.stop(); //stops clip
      clip.close();
    }
  }
//
//  public static void turnMusicOff()
//      throws LineUnavailableException {
//    Clip clip = AudioSystem.getClip();
////    long clipTime = clip.getMicrosecondPosition(); //gets clip position
//    clip.stop(); //stops clip
////    clip.setMicrosecondPosition(clipTime); //sets clip pos
//  }


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

//  public static void main(String[] args) throws InterruptedException, LineUnavailableException {
//    music("resources/song2.wav");
//    Thread.sleep(2000);
//    System.out.println("music is on");
//    turnMusicOff();
//    System.out.println("music is off");
//  }