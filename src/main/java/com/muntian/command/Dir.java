package com.muntian.command;


import com.muntian.ConsoleService;

import java.io.File;

public class Dir implements Command{

    @Override
    public void execute(String... args) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File file = new File(ConsoleService.INSTANCE.getCurrentDirectory());
        String[] content = file.list();
        if(content == null){
            System.out.println("Incorrect path or I/O error!");
            return;
        }
        for (String entry : content) {
            System.out.println(entry);
        }

    }

}
