package com.muntian;

import com.muntian.command.*;

import java.util.HashMap;
import java.util.Map;

public enum ConsoleService {
    INSTANCE;

    private String currentDirectory = System.getProperty("user.home");
    private Map<String, Command> commands = new HashMap<>();

    private void initCommandMap(){
        commands.put("cd", new Cd());
        commands.put("cat", new Cat());
        commands.put("dir", new Dir());
        commands.put("jobs", new Jobs());
        commands.put("help", new Help());
        commands.put("mkdir", new Mkdir());
        commands.put("pwd", new Pwd());
        commands.put("exit", new Exit());
    }

    public String getCurrentDirectory() {
        return currentDirectory;
    }

    public void setCurrentDirectory(String currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    public Map<String, Command> getCommandsMap(){
        if (commands.isEmpty()){
            initCommandMap();
        }
        return commands;
    }
}
