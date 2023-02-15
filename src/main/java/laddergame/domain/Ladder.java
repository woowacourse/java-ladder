package laddergame.domain;

public class Ladder {
    private final Participants participants;
    private final Height height;

    public Ladder(final Participants participants, final Height height) {
        if (participants == null) {
            throw new IllegalArgumentException();
        }
        if (height == null) {
            throw new IllegalArgumentException();
        }
        this.participants = participants;
        this.height = height;
    }
}
