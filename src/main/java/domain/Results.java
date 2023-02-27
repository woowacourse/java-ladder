package domain;

import java.util.List;

public class Results {

    private final List<String> results;

    public Results(List<String> results, int playerCount) {
        validatePlayerCount(results, playerCount);
        this.results = results;
    }

    private void validatePlayerCount(List<String> results, int playerCount) {
        if (results.size() != playerCount) {
            throw new IllegalArgumentException("[ERROR] 결과의 수는 참여자 수와 같아야 합니다.");
        }
    }

    public String getResultByIndex(int index) {
        return results.get(index);
    }

    public int getSize() {
        return results.size();
    }

    public int findMaxResultLength() {
        int maxLength = 0;

        for (String result : results) {
            maxLength = Math.max(maxLength, result.length());
        }

        return maxLength;
    }
}
