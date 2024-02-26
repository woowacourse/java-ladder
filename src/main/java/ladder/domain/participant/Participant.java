package ladder.domain.participant;

public class Participant {
    private final Name name;
    private Position position;

    public Participant(final String name, final int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }

    public void setFinalPosition(final int finalPosition) {
        this.position = new Position(finalPosition);
    }
}
