package view.command;

import java.util.Arrays;

public enum Command {
    ALL("all"),
    FINISH("fin");

    private final String text;

    Command(String text) {
        this.text = text;
    }

    public static boolean isCommand(String text) {
        return Arrays.stream(values())
                .anyMatch(v -> v.text.equals(text));
    }

    public String getText() {
        return text;
    }
}
