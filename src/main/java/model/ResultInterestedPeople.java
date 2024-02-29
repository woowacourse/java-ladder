package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ResultInterestedPeople {
    private final List<String> names;
    private final List<Integer> position;
    private final List<String> executionResult;

    public ResultInterestedPeople(List<String> names, List<String> participantNames) {
        if (names.equals(List.of("all"))) {
            names = participantNames;
        }
        validateNameValue(names);
        validatePersonName(names, participantNames);
        this.names = Objects.requireNonNull(names);
        this.position = findPosition(names, participantNames);
        this.executionResult = new ArrayList<>();
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

    private List<Integer> findPosition(List<String> names, List<String> participantNames) {
        return IntStream.range(0, participantNames.size())
                .filter(i -> names.contains(participantNames.get(i)))
                .boxed()
                .toList();
    }

    public void actualExecutionResult(String result) {
        executionResult.add(result);
    }

    public void forEachPosition(Consumer<Integer> consumer) {
        position.forEach(consumer);
    }

    public List<String> getResultInterestedName() {
        return names;
    }

    public List<Integer> getPosition() {
        return position;
    }

    public List<String> getExecutionResult() {
        return executionResult;
    }
}
