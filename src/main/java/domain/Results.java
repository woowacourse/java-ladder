package domain;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private static final String ALL_PLAYER = "all";

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

    public List<String> getFinalResults(List<String> playersName, List<Integer> lastPositions, String targetPlayer) {
        List<String> results = new ArrayList<>();

        addResult(playersName, lastPositions, targetPlayer, results);
        return results;
    }

    private void addResult(List<String> playersName, List<Integer> lastPositions,
                           String targetPlayer, List<String> results) {
        if (targetPlayer.equals(ALL_PLAYER)) {
            addPlayersResult(playersName, lastPositions, results);
            return;
        }
        addPlayerResult(results, lastPositions.get(playersName.indexOf(targetPlayer)));
    }

    private void addPlayersResult(List<String> playersName, List<Integer> lastPositions, List<String> results) {
        for (int index = 0; index < playersName.size(); index++) {
            results.add(getResult(lastPositions.get(index)));
        }
    }

    private void addPlayerResult(List<String> results, int lastPosition) {
        results.add(getResult(lastPosition));
    }

}
