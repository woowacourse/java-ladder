package laddergame.domain;

import java.util.List;

import static laddergame.messsages.ExceptionMessages.LADDER_HEIGHT_NULL_EXCEPTION;
import static laddergame.messsages.ExceptionMessages.LADDER_PARTICIPANTS_NULL_EXCEPTION;

public class Ladder {
    private final Participants participants;
    private final Height height;


    public Ladder(final Participants participants, final Height height) {
        validateNotNull(participants, height);
        this.participants = participants;
        this.height = height;
    }

    private void validateNotNull(final Participants participants, final Height height) {
        if (participants == null) {
            throw new IllegalArgumentException(LADDER_PARTICIPANTS_NULL_EXCEPTION.getMessage());
        }
        if (height == null) {
            throw new IllegalArgumentException(LADDER_HEIGHT_NULL_EXCEPTION.getMessage());
        }
    }

    public List<Line> createLines(final BooleanGenerator booleanGenerator) {
        final LineCreator lineCreator = new LineCreator(booleanGenerator);
        return lineCreator.createLines(participants.getSize() - 1, height.getValue());
    }
}
