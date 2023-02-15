package domain;

import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.List;

public class Ladder {

    private static final int MIN_HEIGHT = 0;

    private final List<Person> people;
    private final List<Line> lines;

    public Ladder(List<Person> people, List<Line> lines) {
        validateHeightOf(lines);
        this.lines = lines;
        this.people = people;
    }

    private void validateHeightOf(List<Line> lines) {
        if (lines.size() <= MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 양수만 가능합니다");
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<String> getParticipantNames() {
        return people.stream()
                .map(Person::getName)
                .collect(toUnmodifiableList());
    }
}
