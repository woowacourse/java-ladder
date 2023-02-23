package domain.player;

import domain.Position;

import java.util.Objects;

public class Player {

    private final Name name;
    private Position position;
    private String result;

    public Player(String name, int index) {
        this.name = new Name(name);
        this.position = new Position(index);
    }


    public String getName() {
        return name.getName();
    }

    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(name.getName(), player.name.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.getName());
    }
}
