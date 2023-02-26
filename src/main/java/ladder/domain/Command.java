package ladder.domain;

public enum Command {
    ALL("all"), QUIT("quit");

    private String value;

    Command(String value) {
        this.value = value;
    }

    public boolean isEqual(String cmd) {
        return cmd.equals(value);
    }
}
