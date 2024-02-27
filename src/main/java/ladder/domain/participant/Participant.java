package ladder.domain.participant;

public class Participant {
    private final Name name;
    private int position;

    public Participant(final String name, final int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position;
    }

    public void setFinalPosition(final int finalPosition) {
        this.position = finalPosition;
    }
}
