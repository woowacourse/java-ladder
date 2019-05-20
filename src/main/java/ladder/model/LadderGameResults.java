package ladder.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderGameResults {
    private List<LadderGameResult> ladderGameResults;

    public LadderGameResults(String[] inputLadderGameResults, int countOfPlayer) {
        if (inputLadderGameResults.length != countOfPlayer) {
            throw new IllegalArgumentException("잘못된 실행 결과 입니다.");
        }
        ladderGameResults = new ArrayList<>();
        Arrays.stream(inputLadderGameResults).forEach(result -> ladderGameResults.add(new LadderGameResult(result)));
    }

    LadderGameResult getResultByPosition(int position) {
        return ladderGameResults.get(position);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ladderGameResults.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
}
