package domain;

import java.util.List;

import static java.util.List.copyOf;
import static java.util.stream.Collectors.toUnmodifiableList;

public class Ladder {

    private static final int MIN_HEIGHT = 0;

    private final People people;
    private final List<Line> lines;

    public Ladder(final People people, final List<Line> lines) {
        validateHeightOf(lines);
        this.lines = copyOf(lines);
        this.people = people;
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
        return people.getParticipants()
                     .stream()
                     .map(Person::getName)
                     .collect(toUnmodifiableList());
    }
}
