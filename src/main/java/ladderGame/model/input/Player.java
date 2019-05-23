package ladderGame.model.input;

import java.util.Objects;

public class Player {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private String name;

    public Player(String splittedInput) {
        checkLength(splittedInput);
        this.name = splittedInput;
    }

    private void checkLength(String splittedInput) {
        if (splittedInput.length() < MIN_LENGTH || splittedInput.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름의 길이는 1 이상 5이하입니다.");
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


}
