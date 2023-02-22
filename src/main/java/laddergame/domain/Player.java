package laddergame.domain;

public class Player {

    private final Name name;
    private Position position;

    public Player(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public void move(final Position position) {
        this.position = position;
    }

    public int getOrder() {
        return position.getOrder();
    }

    public String getName() {
        return name.getName();
    }

    public int getNameLength() {
        return name.getNameLength();
    }

}
