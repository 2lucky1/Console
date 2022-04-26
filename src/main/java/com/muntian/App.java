package com.muntian;

import com.muntian.command.Command;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static final int COMMAND_NAME = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Command> commandMap = ConsoleService.INSTANCE.getCommandsMap();

        while (true) {
            System.out.print(ConsoleService.INSTANCE.getCurrentDirectory() + ">");
            String input = scan.nextLine();

            if (input.isBlank()) {
                continue;
            }

            boolean inSeparateThread = false;
            if(input.endsWith("&")){
                inSeparateThread = true;
                input = input.substring(0, input.lastIndexOf("&"));
//                             .trim();
            }

            String[] userInput = input.split(" ");

            String commandName = userInput[COMMAND_NAME].toLowerCase();
            String[] commandArgs = Arrays.copyOfRange(userInput, 1, userInput.length);
            if (commandMap.containsKey(commandName)) {
                Command command = commandMap.get(commandName);

                if (inSeparateThread) {
                    Thread thread = new Thread("console " + commandName){
                        @Override
                        public void run() {
                            command.execute(commandArgs);
                        }
                    };
                    thread.start();

                } else {
                    command.execute(commandArgs);
                }

            } else {
                System.out.println("Command " + userInput[COMMAND_NAME] + " not found!");
            }
        }
    }
}
