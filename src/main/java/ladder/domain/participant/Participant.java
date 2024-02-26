package ladder.domain.participant;

public class Participant {
    private final Name name;
    private final Position position;

    public Participant(final String name, final int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
