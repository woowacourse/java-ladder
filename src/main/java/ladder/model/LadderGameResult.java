package ladder.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderGameResult {
    private List<String> ladderGameResults;

    public LadderGameResult(String[] inputLadderGameResults, int countOfPlayer) {
        if (inputLadderGameResults.length != countOfPlayer) {
            throw new IllegalArgumentException("잘못된 실행 결과 입니다.");
        }
        ladderGameResults = new ArrayList<>(Arrays.asList(inputLadderGameResults));
    }


    public String getResultByPosition(int position) {
        return ladderGameResults.get(position);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ladderGameResults.forEach(result -> stringBuilder.append(String.format("%-6s", result)));
        return stringBuilder.toString();
    }
}
