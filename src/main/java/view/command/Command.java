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

    public static boolean isFinishCommand(String value) {
        return value.equals(FINISH.getText());
    }

    public static boolean isAllCommand(String value) {
        return value.equals(ALL.getText());
    }

    public String getText() {
        return text;
    }
}
