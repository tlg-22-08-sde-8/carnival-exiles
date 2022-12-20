package com.carnivalexiles.view;

public class Success {

    // TODO: 12/9/2022 You get rescued on day 7 Screen.

    public static final String WHITE = "\033[0;37m";                          // WHITE TXT
    public static final String RED_BACK = "\033[0;41m";                       // RED BACKGROUND
    public static final String BLACK = "\033[0;30m";                          // BLACK TXT
    public static final String GREEN = "\033[0;32m";                          // GREEN
    public static final String BOLD = "\u001b[1m";                            // BOLD
    public static final String RESET = "\033[0m";                             // Text Reset
    public static final String SUCCESS =                                      //ANSI SHADOW
            ""
                    + " ██████╗ ██████╗ ███╗   ██╗ ██████╗ ██████╗  █████╗ ████████╗███████╗\n"
                    + "██╔════╝██╔═══██╗████╗  ██║██╔════╝ ██╔══██╗██╔══██╗╚══██╔══╝██╔════╝\n"
                    + "██║     ██║   ██║██╔██╗ ██║██║  ███╗██████╔╝███████║   ██║   ███████╗\n"
                    + "██║     ██║   ██║██║╚██╗██║██║   ██║██╔══██╗██╔══██║   ██║   ╚════██║\n"
                    + "╚██████╗╚██████╔╝██║ ╚████║╚██████╔╝██║  ██║██║  ██║   ██║   ███████║\n"
                    + " ╚═════╝ ╚═════╝ ╚═╝  ╚═══╝ ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝   ╚══════╝\n"
                    + "                                                                     \n"
                    + "██╗   ██╗ ██████╗ ██╗   ██╗     ██████╗  ██████╗ ████████╗           \n"
                    + "╚██╗ ██╔╝██╔═══██╗██║   ██║    ██╔════╝ ██╔═══██╗╚══██╔══╝           \n"
                    + " ╚████╔╝ ██║   ██║██║   ██║    ██║  ███╗██║   ██║   ██║              \n"
                    + "  ╚██╔╝  ██║   ██║██║   ██║    ██║   ██║██║   ██║   ██║              \n"
                    + "   ██║   ╚██████╔╝╚██████╔╝    ╚██████╔╝╚██████╔╝   ██║              \n"
                    + "   ╚═╝    ╚═════╝  ╚═════╝      ╚═════╝  ╚═════╝    ╚═╝              \n"
                    + "                                                                     \n"
                    + "██████╗ ███████╗███████╗ ██████╗██╗   ██╗███████╗██████╗ ██╗         \n"
                    + "██╔══██╗██╔════╝██╔════╝██╔════╝██║   ██║██╔════╝██╔══██╗██║         \n"
                    + "██████╔╝█████╗  ███████╗██║     ██║   ██║█████╗  ██║  ██║██║         \n"
                    + "██╔══██╗██╔══╝  ╚════██║██║     ██║   ██║██╔══╝  ██║  ██║╚═╝         \n"
                    + "██║  ██║███████╗███████║╚██████╗╚██████╔╝███████╗██████╔╝██╗         \n"
                    + "╚═╝  ╚═╝╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚══════╝╚═════╝ ╚═╝         \n"
                    + "                                                                     \n"
                    + "                                                                     \n"
                    + "                                                                     \n"
                    + "                                                                     \n"
                    + "                                                                     \n"
                    + "                                                                     \n"
                    + "                                                                     \n"
                    + "                                                                     ";

    public static void displaySuccess() {
        System.out.println(GREEN + BOLD + "\n" + SUCCESS + "\n" + RESET);
    }
}