package domain.result;

import domain.player.Player;
import java.util.List;

public class Results {
    public static final String OUT_OF_BOUND_EXCEPTION_MESSAGE = "[ERROR] 범위를 벗어난 인덱스는 입력할 수 없습니다.";

    private final List<Result> results;

    public Results(final List<Result> results) {
        this.results = results;
    }

    public Result findResultByIndex(final int index) {
        if (index < 0 || index >= results.size()) {
            throw new IllegalArgumentException(OUT_OF_BOUND_EXCEPTION_MESSAGE);
        }
        return results.get(index);
    }

    public Result findResultByPlayer(final Player player) {
        return findResultByIndex(player.getPosition());
    }

    public List<Result> getResults() {
        return results;
    }
}
