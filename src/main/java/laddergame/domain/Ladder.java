package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

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

    public List<Line> createLines() {
        LineCreator lc = new LineCreator(new RandomBooleanGenerator());
        return lc.createLines();
    }
}
