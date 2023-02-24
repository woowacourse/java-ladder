package ladder.domain;

public class Player {
    private final Name name;
    private final Position position;

    public Player(String nameValue, int positionValue) {
        this.name = new Name(nameValue);
        this.position = new Position(positionValue);
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }

    public void move(Ladder ladder) {
        ladder.moveToResult(position);
    }

    public boolean isMatchesBy(String name) {
        return this.name.equals(new Name(name));
    }
}
