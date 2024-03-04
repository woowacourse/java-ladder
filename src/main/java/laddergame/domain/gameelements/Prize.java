package laddergame.domain.gameelements;

public class Prize {
    private final Name name;
    private final Position position;

    public Prize(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public boolean isSamePosition(Position otherPosition) {
        return position.isSame(otherPosition);
    }

    public String getName() {
        return name.getName();
    }

    public Position getPosition() {
        return position;
    }
}
