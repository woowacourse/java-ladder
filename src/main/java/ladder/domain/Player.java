package ladder.domain;

import java.util.Optional;

public class Player {
    private final Name name;
    private Result result;

    public Player(String nameValue) {
        this.name = new Name(nameValue);
        this.result = null;
    }

    public Name getName() {
        return name;
    }

    public void saveResult(Result result) {
        this.result = result;
    }
}
