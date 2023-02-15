package laddergame.domain;

public class Player {

    private final String name;

    public Player(String name) {
        validatePlayerName(name);
        this.name = name;
    }

    private void validatePlayerName(String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 플레이어 이름은 공백이 아닌 5글자 이하여야 합니다.");
        }
    }
}
