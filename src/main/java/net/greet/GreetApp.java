package net.greet;

import java.util.Scanner;

public class GreetApp {

    public static void printMessage(String msg) {
        final String BLUE_BOLD = "\033[1;34m";   // BLUE
        final String BLUE_BACKGROUND = "\033[44m";   // BLUE
        final String RESET = "\033[0m";
        final String WHITE_BACKGROUND = "\033[47m";  // WHITE
        final String WHITE_BOLD = "\033[1;37m";  // WHITE
        System.out.println(BLUE_BOLD + msg + " " + RESET);
    }

    public static void main(String[] args) {
        GreetingLanguage greetingLanguage = new GreetingLanguage();
        final GreetCounter greetCounter = new GreetCounterUsingJdbc();
        GreetService greetService = new GreetService(greetCounter, greetingLanguage);
        CommandExecuter commandExecuter = new CommandExecuter(greetService);
        Scanner commandRead = new Scanner(System.in);

        while (true) {
            System.out.print("Please enter a command: ");
            String commandIdentity = commandRead.nextLine();
            CommandExtractor commandExtractor = new CommandExtractor(commandIdentity);
            String result = commandExecuter.excuteCommand(commandExtractor);
            if ("exit".equals(commandExtractor.getCommand())){
                printMessage("Good-Bye");
                break;
            }
            printMessage(result);

            }
        }
    }



