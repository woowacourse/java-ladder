package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Results {

    private static final String ALL_PLAYER = "all";
    private static final int SINGLE_SIZE = 1;

    static final String SIZE_ERROR = "[ERROR] 결과값을 참여자 수 만큼 입력해야합니다.";

    private final List<Result> results = new ArrayList<>();

    public Results(int count, List<String> results) {
        validateSize(count, results);
        addResult(results);
    }

    private void addResult(List<String> results) {
        for (String result : results) {
            this.results.add(new Result(result));
        }
    }

    private void validateSize(int count, List<String> results) {
        if (results.size() != count) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }

    public List<String> getResult() {
        List<String> results = new ArrayList<>();

        for (Result result : this.results) {
            results.add(result.getName());
        }
        return results;
    }

    public String getResult(int position) {
        return results.get(position)
                .getName();
    }

    public Results getFinalResults(List<String> playersName, List<Integer> lastPositions, String targetPlayer) {
        if (targetPlayer.equals(ALL_PLAYER)) {
            List<String> allPlayerResult = getAllPlayerResult(lastPositions);

            return new Results(allPlayerResult.size(), allPlayerResult);
        }
        return new Results(1, List.of(getSinglePlayerResult(playersName, lastPositions, targetPlayer)));
    }

    private String getSinglePlayerResult(List<String> playersName, List<Integer> lastPositions, String targetPlayer) {
        int index = playersName.indexOf(targetPlayer);
        return getResult(lastPositions.get(index));
    }

    private List<String> getAllPlayerResult(List<Integer> lastPositions) {
        return lastPositions.stream()
                .map(this::getResult)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Results results1 = (Results) o;
        return Objects.equals(results, results1.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

    public boolean isAllPlayerResults() {
        return results.size() != SINGLE_SIZE;
    }
}
