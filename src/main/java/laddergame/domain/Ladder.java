package laddergame.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {
    private static final String LADDER_PARTICIPANTS_NULL_EXCEPTION = "참여자는 null이 될 수 없습니다.";
    private static final String LADDER_HEIGHT_NULL_EXCEPTION = "높이는 null이 될 수 없습니다.";

    private final Participants participants;
    private final Height height;

    public Ladder(final Participants participants, final Height height) {
        validateNotNull(participants, height);
        this.participants = participants;
        this.height = height;
    }

    private void validateNotNull(final Participants participants, final Height height) {
        if (Objects.isNull(participants)) {
            throw new IllegalArgumentException(LADDER_PARTICIPANTS_NULL_EXCEPTION);
        }
        if (Objects.isNull(height)) {
            throw new IllegalArgumentException(LADDER_HEIGHT_NULL_EXCEPTION);
        }
    }

    public List<Line> createLines(final BooleanGenerator booleanGenerator) {
        final LineCreator lineCreator = new LineCreator(booleanGenerator);
        return lineCreator.createLines(participants.getSize() - 1, height.getValue());
    }
}
