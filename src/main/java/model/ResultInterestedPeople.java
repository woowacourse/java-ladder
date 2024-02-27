package model;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class ResultInterestedPeople {
    private final List<String> names;

    public ResultInterestedPeople(List<String> names, List<String> participantNames) {
        if (names.equals(List.of("all"))) {
            names = participantNames;
        }
        validateNameValue(names);
        validatePersonName(names, participantNames);
        this.names = Objects.requireNonNull(names);
    }

    private void validatePersonName(List<String> names, List<String> participantNames) {
        long matchCount = names.stream()
                .filter(name -> participantNames.stream().anyMatch(Predicate.isEqual(name)))
                .count();

        if (matchCount < 1) {
            throw new IllegalArgumentException("결과를 보고 싶은 사람은 참여한 사람이어야 한다");
        }
    }

    private void validateNameValue(List<String> names) {
        if (names.isEmpty() || names.contains("\\s+")) {
            throw new IllegalArgumentException("결과를 보고 싶은 사람은 한 명 이상이어야 한다");
        }
    }

    public List<String> getResultInterestedName() {
        return names;
    }
}
