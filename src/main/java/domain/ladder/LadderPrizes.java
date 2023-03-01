package domain.ladder;

import java.util.List;
import java.util.stream.Stream;

public class LadderPrizes {

    private final List<LadderPrize> ladderPrizes;

    private LadderPrizes(List<LadderPrize> ladderPrizes) {
        this.ladderPrizes = ladderPrizes;
    }

    //TODO: size 비교가 어떤 객체의 책임인지 생각
    public static LadderPrizes createWithSameSize(List<LadderPrize> ladderPrizes, int size) {
        if (ladderPrizes.size() != size) {
            throw new IllegalArgumentException("크기가 일치하지 않습니다.");
        }

        return new LadderPrizes(ladderPrizes);
    }

    public LadderPrize findPrizeByPosition(int position) {
        return ladderPrizes.get(position - 1);
    }

    public Stream<LadderPrize> stream() {
        return ladderPrizes.stream();
    }
}
