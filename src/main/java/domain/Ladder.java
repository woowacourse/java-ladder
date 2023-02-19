package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.List.copyOf;
import static java.util.stream.Collectors.toUnmodifiableList;

public class Ladder {

    private static final int MIN_HEIGHT = 0;

    private final People people;
    private final Line line;
    private final List<String> resultCandidates;

    public Ladder(final People people, final Line line, final List<String> resultCandidates) {
        validateEqualsSizeOf(people, resultCandidates);
        this.line = line;
        this.people = people;
        this.resultCandidates = copyOf(resultCandidates);
    }

    private void validateEqualsSizeOf(People people, List<String> resultCandidates) {
        if (people.getParticipantsSize() != resultCandidates.size()) {
            throw new IllegalArgumentException("실행 결과 개수는 참가자 수와 같아야합니다.");
        }
    }

    public List<Bridge> getLines() {
        return line.getBridges();
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

            for (Bridge bridge : line.getBridges()) {
                index = moveBridge(index, bridge);
            }

            result.put(name, resultCandidates.get(index));
        }

        return result;
    }

    private int moveBridge(int index, Bridge bridge) {
        if (bridge.hasLeftBridge(index)) {
            return index - 1;
        }

        if (bridge.hasRightBridge(index)) {
            return index + 1;
        }

        return index;
    }

    public List<String> getResultCandidates() {
        return resultCandidates;
    }
}
