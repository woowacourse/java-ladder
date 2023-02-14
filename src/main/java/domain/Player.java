package domain;

public class Player {

    private final String name;

    public Player(String name) {
        validateBlank(name);
        this.name = name;
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 이름은 공백이 될 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
