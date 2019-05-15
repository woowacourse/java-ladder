package ladder;

public class Player {
    private final String name;

    public Player(String name) {
        validName(name);
        this.name = name;
    }

    private void validName(String name) {
        checkBlank(name);
        if (name.length() > 5){
            throw new IllegalArgumentException();
        }
    }

    private void checkBlank(String name) {
        if (name.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }
}
