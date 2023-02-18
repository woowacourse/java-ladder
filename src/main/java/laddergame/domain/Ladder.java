package laddergame.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {
    private final Participants participants;
    private final Height height;

    public Ladder(final Participants participants, final Height height) {
        validateNotNull(participants, height);
        this.participants = participants;
        this.height = height;
    }

    private void validateNotNull(final Participants participants, final Height height) {
        if (Objects.isNull(participants)) {
            throw new IllegalArgumentException("참여자는 null이 될 수 없습니다.");
        }
        if (Objects.isNull(height)) {
            throw new IllegalArgumentException("높이는 null이 될 수 없습니다.");
        }
    }

    public List<Line> createLines(final BooleanGenerator booleanGenerator) {
        final LineCreator lineCreator = new LineCreator(booleanGenerator);
        return lineCreator.createLines(participants.getSize() - 1, height.getValue());
    }
}
