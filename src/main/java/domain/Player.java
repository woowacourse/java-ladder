package domain;

public class Player {

    private final String name;

    public Player(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 이름은 공백이 될 수 없습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
