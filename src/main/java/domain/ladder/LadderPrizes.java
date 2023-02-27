package domain.ladder;

import domain.player.Position;
import java.util.List;
import java.util.stream.Stream;

public class LadderPrizes {

    private final List<LadderPrize> ladderPrizes;

    private LadderPrizes(List<LadderPrize> ladderPrizes) {
        this.ladderPrizes = ladderPrizes;
    }

    public static LadderPrizes createWithSameSize(List<LadderPrize> ladderPrizes, int size) {
        if (ladderPrizes.size() != size) {
            throw new IllegalArgumentException("크기가 일치하지 않습니다.");
        }

        return new LadderPrizes(ladderPrizes);
    }

    public LadderPrize findPrizeByPosition(Position position) {

        return ladderPrizes.get(position.getPosition() - 1);
    }

    public Stream<LadderPrize> stream() {
        return ladderPrizes.stream();
    }
}
