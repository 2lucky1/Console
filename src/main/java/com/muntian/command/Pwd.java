package com.muntian.command;

import com.muntian.ConsoleService;

public class Pwd implements Command{
    @Override
    public void execute(String... args) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ConsoleService.INSTANCE.getCurrentDirectory());
    }
}
