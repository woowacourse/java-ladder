package model;

public class Player {
    private final Name name;
    private Result result;

    public Player(final Name name) {
        this.name = name;
    }

    public String getName() {
        return name.getValue();
    }

    public String getResult() {
        return result.getValue();
    }

    public void saveResult(final Result result) {
        this.result = result;
    }
}
