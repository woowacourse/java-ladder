package domain;

import static java.util.List.copyOf;

import java.util.List;

public class Ladder {

    private static final int MIN_HEIGHT = 0;

    private final Participants participants;
    private final List<Line> lines;

    public Ladder(final Participants participants, final List<Line> lines) {
        validateHeightOf(lines);
        this.participants = participants;
        this.lines = copyOf(lines);
    }

    private void validateHeightOf(final List<Line> lines) {
        if (lines.size() <= MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 양수만 가능합니다");
        }
    }

    public Participants getParticipants() {
        return participants;
    }

    public List<Line> getLines() {
        return lines;
    }
}
