package ladder.domain;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String BLANK = "";

    private final String name;

    public Player(String name) {
        validName(name);
        this.name = name;
    }

    private void validName(String name) {
        checkBlank(name);
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void checkBlank(String name) {
        if (name.equals(BLANK)) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

}
