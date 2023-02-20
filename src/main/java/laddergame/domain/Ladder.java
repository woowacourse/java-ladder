package laddergame.domain;

import java.util.List;
import java.util.Optional;

public class Ladder {
    private static final String LADDER_PARTICIPANTS_NULL_EXCEPTION = "참여자는 null이 될 수 없습니다.";
    private static final String LADDER_HEIGHT_NULL_EXCEPTION = "높이는 null이 될 수 없습니다.";

    private final Participants participants;
    private final Height height;

    public Ladder(final Participants participants, final Height height) {
        this.participants = Optional.ofNullable(participants).orElseThrow(() ->
                new IllegalArgumentException(LADDER_PARTICIPANTS_NULL_EXCEPTION));
        
        this.height = Optional.ofNullable(height).orElseThrow(() ->
                new IllegalArgumentException(LADDER_HEIGHT_NULL_EXCEPTION));
    }

    public List<Line> createLines(final BooleanGenerator booleanGenerator) {
        final LineCreator lineCreator = new LineCreator(booleanGenerator);
        return lineCreator.createLines(participants.getSize() - 1, height.getValue());
    }
}
