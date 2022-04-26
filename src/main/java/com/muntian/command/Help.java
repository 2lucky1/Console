package com.muntian.command;

public class Help implements Command{
    @Override
    public void execute(String... args) {
        System.out.println("cd - Changes current directory");
        System.out.println("cat - Shows content of a specified file");
        System.out.println("dir - Shows content of a current directory");
        System.out.println("help - Shows all commands with its description");
        System.out.println("exit - exit");
    }
}
