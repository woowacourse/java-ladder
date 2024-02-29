package ladder.domain.participant;

public class Participant {
    private final Name name;

    public Participant(final String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return name.getValue();
    }
}
