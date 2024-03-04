package laddergame.domain.gameelements;

public class Prize {
    private final Name name;
    private final Position position;

    public Prize(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name.getName();
    }

    public Position getPosition() {
        return position;
    }
}
