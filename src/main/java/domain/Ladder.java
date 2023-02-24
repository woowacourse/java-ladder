package domain;

import java.util.List;

import static java.util.List.copyOf;
import static java.util.stream.Collectors.toUnmodifiableList;

public class Ladder {

    private final People people;
    private final Line line;
    private final List<String> resultCandidates;

    public Ladder(final People people, final Line line, final List<String> resultCandidates) {
        validateEqualsSizeOf(people, resultCandidates);
        this.line = line;
        this.people = people;
        this.resultCandidates = copyOf(resultCandidates);
    }

    private void validateEqualsSizeOf(final People people, final List<String> resultCandidates) {
        if (people.getParticipantsSize() != resultCandidates.size()) {
            throw new IllegalArgumentException("실행 결과 개수는 참가자 수와 같아야합니다.");
        }
    }

    public String getLadderMatchingPersonalResult(String name) {

        int ladderStartIndex = people.getParticipants().indexOf(new Person(name));

        if (ladderStartIndex == -1) {
            throw new IllegalArgumentException("참여자가 없습니다.");
        }

        int destination = line.move(ladderStartIndex);

        return resultCandidates.get(destination);
    }

    public List<Bridge> getBridges() {
        return line.getBridges();
    }

    public List<String> getParticipantNames() {
        return people.getParticipants()
                     .stream()
                     .map(Person::getName)
                     .collect(toUnmodifiableList());
    }

    public List<String> getResultCandidates() {
        return resultCandidates;
    }
}
