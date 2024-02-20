package domain;

public class PlayerName {
    private String name;

    public PlayerName(String name) {
        this.name = name;

        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }
}
