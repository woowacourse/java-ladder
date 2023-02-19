package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.List.copyOf;
import static java.util.stream.Collectors.toUnmodifiableList;

public class Ladder {

    private static final int MIN_HEIGHT = 0;

    private final People people;
    private final List<Line> lines;
    private List<String> resultCandidates; //TODO : 재할당 금지 + 불변성 보장 해야함

    public Ladder(final People people, final List<Line> lines, final List<String> resultCandidates) {
        validateHeightOf(lines);
        validateEqualsSizeOf(people, resultCandidates);
        this.lines = copyOf(lines);
        this.people = people;
        this.resultCandidates = copyOf(resultCandidates);
    }

    public Ladder(final People people, final List<Line> lines) {
        validateHeightOf(lines);
        this.lines = copyOf(lines);
        this.people = people;
    }

    private void validateEqualsSizeOf(People people, List<String> resultCandidates) {
        if (people.getParticipantsSize() != resultCandidates.size()) {
            throw new IllegalArgumentException("실행 결과 개수는 참가자 수와 같아야합니다.");
        }
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

    public Map<String, String> getLadderMatchingResult() {

        Map<String, String> result = new HashMap<>();

        List<String> participantNames = getParticipantNames();

        for (int start = 0; start < participantNames.size(); start++) {

            String name = participantNames.get(start);
            int index = start;

            for (Line line : lines) {
                index = moveBridge(index, line);
            }

            result.put(name, resultCandidates.get(index));
        }

        return result;
    }

    private int moveBridge(int index, Line line) {
        if (line.hasLeftBridge(index)) {
            return index - 1;
        }

        if (line.hasRightBridge(index)) {
            return index + 1;
        }

        return index;
    }
}
