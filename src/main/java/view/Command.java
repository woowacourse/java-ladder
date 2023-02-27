package view;

public enum Command {
    ALL("all"),
    QUIT("quit");

    private final String name;

    Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
