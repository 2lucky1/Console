package com.muntian.command;

import java.util.Set;
import java.util.stream.Collectors;

public class Jobs implements Command {
    @Override
    public void execute(String... args) {
        Set<Thread> threadSet
                = Thread.getAllStackTraces()
                        .keySet();
//                        .stream()
//                        .filter((thread) -> thread.getName().contains("console"))
//                        .collect(Collectors.toSet());

        for (Thread t : threadSet) {
            System.out.println("Thread :" + t.getName() + ":"
                    + "Thread status : "
                    + t.getState());
        }
    }
}
