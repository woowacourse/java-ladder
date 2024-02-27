package ladderGame.model;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;
    private final LadderResults ladderResults;

    public LadderGame(Players players, LadderResults ladderResults, Ladder ladder) {
        this.players = players;
        this.ladderResults = ladderResults;
        this.ladder = ladder;
    }

    public LadderResult findLadderGameResult(String name) {
        Integer startIndex = players.indexOfPlayerByName(name);

        if (startIndex == null) {
            throw new IllegalStateException("존재하지 않는 참가자 이름입니다.");
        }

        int resultIndex = ladder.findLadderResultIndex(startIndex);
        return ladderResults.getLadderResults().get(resultIndex);
    }

    public List<LadderResult> findAllLadderGameResults() {
        List<LadderResult> results = new ArrayList<>();
        List<LadderResult> originalResults = ladderResults.getLadderResults();
        for (int index = 0; index < players.getPlayerSize(); index++) {
            int resultIndex = ladder.findLadderResultIndex(index);
            results.add(originalResults.get(resultIndex));
        }

        return results;
    }
}
