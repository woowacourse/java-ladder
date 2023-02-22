package domain;

import static java.util.List.copyOf;

import java.util.List;

public class Ladder {

    private static final int MIN_HEIGHT = 0;

    private final Participants participants;
    private final List<Line> lines;
    private final List<String> prizes;

    public Ladder(final Participants participants, final List<Line> lines, List<String> prizes) {
        validateHeightOf(lines);
        this.participants = participants;
        this.lines = copyOf(lines);
        this.prizes = copyOf(prizes);
    }

    private void validateHeightOf(final List<Line> lines) {
        if (lines.size() <= MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 양수만 가능합니다");
        }
    }

    public String findPrizeFor(String participantName) {
        Position position = participants.findPositionOf(participantName);
        for (Line line : lines) {
            position = line.moveFrom(position);
        }
        return getPrizeAt(position);
    }

    private String getPrizeAt(Position position) {
        return prizes.get(position.getPosition());
    }

    public List<String> getParticipantNames() {
        return participants.getNames();
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<String> getPrizes() {
        return prizes;
    }
}
