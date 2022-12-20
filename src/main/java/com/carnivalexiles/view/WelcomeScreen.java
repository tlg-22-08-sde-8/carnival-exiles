package com.carnivalexiles.view;

public class WelcomeScreen {
    public static final String GREEN = "\033[0;32m";                          // GREEN
    public static final String BOLD = "\u001b[1m";                            // BOLD
    public static final String BOLD_RED = "\u001b[1m\u001b[31m\u001b[4m";     // BOLD RED UNDERLINE
    public static final String RESET = "\033[0m";                             // Text Reset
    public static final String TITLE =
            "██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗            ████████╗ ██████╗ \n"
                    + "██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝            ╚══██╔══╝██╔═══██╗\n"
                    + "██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗                 ██║   ██║   ██║\n"
                    + "██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝                 ██║   ██║   ██║\n"
                    + "╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗               ██║   ╚██████╔╝\n"
                    + " ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝               ╚═╝    ╚═════╝ \n"
                    + "                                                                                            "
                    +
                    " \n██████╗ █████╗ ██████╗ ███╗   ██╗██╗██╗   ██╗ █████╗ ██╗                 ███████╗██╗  ██╗██╗██╗     ███████╗███████╗\n"
                    + "██╔════╝██╔══██╗██╔══██╗████╗  ██║██║██║   ██║██╔══██╗██║                 ██╔════╝╚██╗██╔╝██║██║     ██╔════╝██╔════╝\n"
                    + "██║     ███████║██████╔╝██╔██╗ ██║██║██║   ██║███████║██║                 █████╗   ╚███╔╝ ██║██║     █████╗  ███████╗\n"
                    + "██║     ██╔══██║██╔══██╗██║╚██╗██║██║╚██╗ ██╔╝██╔══██║██║                 ██╔══╝   ██╔██╗ ██║██║     ██╔══╝  ╚════██║\n"
                    + "╚██████╗██║  ██║██║  ██║██║ ╚████║██║ ╚████╔╝ ██║  ██║███████╗            ███████╗██╔╝ ██╗██║███████╗███████╗███████║\n"
                    + " ╚═════╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═══╝  ╚═╝  ╚═╝╚══════╝            ╚══════╝╚═╝  ╚═╝╚═╝╚══════╝╚══════╝╚══════╝\n"
                    + "                                                                                                                     ";

    public static void displayTitle() {
        System.out.println(GREEN + "\n" + TITLE + "\n" + RESET);
    }

    public static void displayIntroduction() {
        System.out.println("Taking a vacation to celebrate your recent promotion, " +
                "you found yourself on the biggest Carnival cruise ship in the world! \n" +
                "\tHankering for some pankering, you went to the port-side buffet. \n" +
                "\tAs you reached for the last piece of bacon, after stuffing a dozen in " +
                "your trusty waterproof fanny pack, \n" +
                "\ta hungover ruffian fights you for the piece and throws you overboard. \n" +
                "\tAs you plummet to the unseen depths below, you quickly munch on the crispy " +
                "apple-wood smoked bacon and feel victorious. \n\n" +
                "... Sometime later, you wake up to a monkey bonking you on the head with a " +
                "bottle on a mysterious Island... \n"
                + "all while he's eating your fanny pack bacon...\n");
        displayObjective();
    }

    public static void displayObjective() {
        System.out.println(BOLD + "OBJECTIVE: " + RESET
                + "Explore the lands! Interact with the wildlife! Eat some interesting food!\n"
                + BOLD_RED + "Do not let your health points (HP) fall below zero!\n\n" + RESET
                + "P.S. Watch out for traps!\n");
        System.out.println("Would you like to start your true vacation adventure? (Enter any key or 'Quit')");
    }
}