package com.spring.knights;

import java.io.PrintStream;

public class SalyDragonQuest implements Quest {
    private PrintStream stream;

    public SalyDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    public void embark() {
        stream.println("Embarking on quest to slay the dragon");
    }
}
