package ladder.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Player(final String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("올바르지 않은 이름입니다.");
        }
        this.name = name;
    }

    int playGame(Ladder ladder, int startPosition) {
        int currentPosition = startPosition;
        for (int currentLine = 0; currentLine < ladder.ladderSize(); currentLine++) {
            currentPosition += ladder.getLine(currentLine).move(currentPosition);
        }
        return currentPosition;
    }

    String getName() {
        return this.name;
    }

    private boolean isValidName(String name) {
        return (!StringUtils.isBlank(name)) && (name.length() <= MAX_NAME_LENGTH);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("%-6s", this.name);
    }
}
