package domain;

import static java.util.List.copyOf;
import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.List;

public class Ladder {

    private static final int MIN_HEIGHT = 0;

    private final List<Participant> people;
    private final List<Line> lines;

    public Ladder(final List<Participant> people, final List<Line> lines) {
        validateHeightOf(lines);
        this.lines = copyOf(lines);
        this.people = copyOf(people);
    }

    private void validateHeightOf(final List<Line> lines) {
        if (lines.size() <= MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 양수만 가능합니다");
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<String> getParticipantNames() {
        return people.stream()
                .map(Participant::getName)
                .collect(toUnmodifiableList());
    }
}
