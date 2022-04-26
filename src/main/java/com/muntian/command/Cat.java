package com.muntian.command;

import com.muntian.ConsoleService;

import java.io.*;

public class Cat implements Command {

    @Override
    public void execute(String... args) {
        if (args.length != 1) {
            System.out.println("Incorrect argument!");
            return;
        }
        String fileName = args[0];
        File file = new File(fileName);
        if (file.isFile()) {
            printContent(file);
        }else {
            String absolutPath = ConsoleService.INSTANCE.getCurrentDirectory() + File.pathSeparator + fileName;
            file = new File(absolutPath);
            if(file.isFile()){
                printContent(file);
            }else {
                System.out.println("There is no file with a name " + fileName);
            }
        }

    }

    private void printContent(File file){
        try (FileReader fileReader = new FileReader(file);
             BufferedReader reader = new BufferedReader(fileReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
