package ladder.domain;

import ladder.util.Rule;

import java.util.Objects;

public class Player {
    private final String name;
    private int position;

    public Player(String name) {
        this(name, 0);
    }

    public Player(String name, int position) {
        Rule.ruleNameOverLength(name);
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveLeftPosition() {
        --this.position;
    }

    public void moveRightPosition() {
        ++this.position;
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
