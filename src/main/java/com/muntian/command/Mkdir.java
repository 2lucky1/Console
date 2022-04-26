package com.muntian.command;

import com.muntian.ConsoleService;

import java.io.File;

public class Mkdir implements Command{
    @Override
    public void execute(String... args) {
        String path = args[0];
        File file = new File(path);
        if(!file.isAbsolute()){
            path = ConsoleService.INSTANCE.getCurrentDirectory() + File.separator + path;
            file = new File(path);
        }
        if(!file.mkdir()){
            System.out.println("Directory with name " + args[0] + " was not created!");
        }
    }
}
