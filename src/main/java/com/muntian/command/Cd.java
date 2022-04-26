package com.muntian.command;

import com.muntian.ConsoleService;

import java.io.File;

public class Cd implements Command {

    public static final int TARGET_PATH = 0;

    @Override
    public void execute(String... args) {
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if(args.length == 0){
            ConsoleService.INSTANCE.setCurrentDirectory(System.getProperty("user.home"));
            return;
        }
        if (args.length > 1) {
            System.out.println("Incorrect argument");
            return;
        }

        String path = args[TARGET_PATH];
        File file = new File(path);
        if (file.isDirectory()) {
            ConsoleService.INSTANCE.setCurrentDirectory(path);
        } else {
            String absolutPath = ConsoleService.INSTANCE.getCurrentDirectory() + File.separator + path;
            file = new File(absolutPath);
            if (file.isDirectory()) {
                ConsoleService.INSTANCE.setCurrentDirectory(absolutPath);
            } else {
                System.out.println("Path " + path + " does not exist!");
            }
        }
    }

}
