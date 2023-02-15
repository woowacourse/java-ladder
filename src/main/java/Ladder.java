import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Boolean> ladder;

    Ladder(List<Boolean> ladder) {
        for (int index = 1; index < ladder.size(); index++) {
            Boolean currentBridge = ladder.get(index);
            Boolean previousBridge = ladder.get(index - 1);
            if (currentBridge && previousBridge) {
                throw new IllegalArgumentException("다리는 연속으로 생성되면 안됩니다.");
            }
        }
        this.ladder = ladder;
    }

    public List<Boolean> getLadder() {
        return new ArrayList<>(ladder);
    }
}
