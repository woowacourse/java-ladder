package ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class LadderResult {
    private Map<Player, ResultItem> ladderingResult = new LinkedHashMap<>();

    public void addResult(Player player, ResultItem resultItem) {
        ladderingResult.put(player, resultItem);
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
