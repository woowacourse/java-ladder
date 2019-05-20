package ladder.model.laddergame;

import java.util.List;

public class LadderGameResult {
    private static final String NAME_SPACE_FORMAT = "%-6s";
    private List<String> ladderGameResults;

    public LadderGameResult(List<String> ladderGameResults, int countOfPlayer) {
        validateLadderGameResults(ladderGameResults, countOfPlayer);
        this.ladderGameResults = ladderGameResults;
    }

    private void validateLadderGameResults(List<String> ladderGameResults, int countOfPlayer){
        if (isDifferent(ladderGameResults.size(), countOfPlayer)) {
            throw new IllegalArgumentException("실행 결과의 수가 플레이어의 수와 다릅니다.");
        }
    }

    private boolean isDifferent(int a, int b){
        return a != b;
    }

    public String getResultByPosition(int position) {
        return ladderGameResults.get(position);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ladderGameResults.forEach(result -> stringBuilder.append(String.format(NAME_SPACE_FORMAT, result)));
        return stringBuilder.toString();
    }
}
