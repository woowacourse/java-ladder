package ladder.domain;

import java.util.*;

public class LadderResult {
    private Map<Player, ResultItem> ladderingResult = new LinkedHashMap<>();

    public LadderResult(PlayerGroup players, ResultItems resultItems, List<Integer> ladderingResultItemsIndex) {
        for (int index = 0; index < players.size(); index++) {
            ladderingResult.put(players.answerMatchPlayerOf(index), resultItems.answerMatchItemOf(ladderingResultItemsIndex.get(index)));
        }
    }

    public ResultItem getResultOf(String name) {
        if (!ladderingResult.containsKey(new Player(name))) {
            throw new IllegalArgumentException("존재하지 않는 플레이어입니다.");
        }
        return ladderingResult.get(new Player(name));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(ladderingResult, that.ladderingResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderingResult);
    }

    public Map<Player, ResultItem> getResultAll() {
        return ladderingResult;
    }
}
