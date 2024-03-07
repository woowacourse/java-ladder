package ladder.domain;

public enum Command {
    ALL_RESULT("all");

    private final String text;

    Command(String text) {
        this.text = text;
    }

    public boolean isText(String input) {
        return text.equals(input);
    }
}
