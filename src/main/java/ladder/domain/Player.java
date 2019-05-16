package ladder.domain;

import java.util.Objects;

public class Player {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MINIMUM_NANE_LENGTH = 1;
    private static final String SHOW_ALL_COMMAND = "all";
    private final String name;
    private int position;

    public Player(final String name) {
        this(name, 0);
    }

    public Player(final String name, int position) {
        nullCheck(name);
        this.name = getTrimed(name);
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    private void nullCheck(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름에는 null이 입력될 수 없습니다.");
        }
    }

    private String getTrimed(String name) {
        name = name.trim();
        vaildateCommandName(name);
        vaildateNameLength(name);
        return name;
    }

    private void vaildateCommandName(String name) {
        if (name.equals(SHOW_ALL_COMMAND)) {
            throw new IllegalArgumentException("이름에는 all이 입력될 수 없습니다.");
        }
    }

    private void vaildateNameLength(String name) {
        if ((name.length() > MAXIMUM_NAME_LENGTH) || (name.length() < MINIMUM_NANE_LENGTH)) {
            throw new IllegalArgumentException("이름의 길이는 5자 이하여야 합니다.");
        }
    }

    public void stepDown(Crosspoints crosspoints) {
        position = crosspoints.answerResultIndexOf(position);
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
