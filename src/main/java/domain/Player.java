package domain;

public class Player {

    private final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("[Error] 플레이어 이름은 5자 이하여야 합니다.");
        }
    }
}
