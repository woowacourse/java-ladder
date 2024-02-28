package domain;


import java.util.Arrays;

public enum Commands {

    TERMINATE("all");

    private final String value;

    Commands(final String value) {
        this.value = value;
    }

    public static boolean terminate(String command) {
        return TERMINATE.value.equals(command);
    }

    public static boolean exists(String value) {
        return Arrays.stream(values())
                .anyMatch(command -> command.getValue().equals(value));
    }

    public String getValue() {
        return value;
    }
}
