package domain.ladder;

import domain.player.Position;
import java.util.List;
import java.util.stream.Stream;

public class LadderPrizes {

    private final List<LadderPrize> ladderPrizes;

    public LadderPrizes(List<LadderPrize> ladderPrizes) {
        validate(ladderPrizes);
        this.ladderPrizes = ladderPrizes;
    }

    private void validate(List<LadderPrize> ladderPrizes) {
        if (hasDuplicatePosition(ladderPrizes)) {
            throw new IllegalArgumentException("중복된 위치가 존재합니다.");
        }
    }

    private boolean hasDuplicatePosition(List<LadderPrize> ladderPrizes) {
        return ladderPrizes.size() != ladderPrizes.stream()
                .map(LadderPrize::getPosition)
                .distinct()
                .count();
    }

    public LadderPrize findPrizeByPosition(Position position) {
        return ladderPrizes.stream()
                .filter(ladderPrize -> ladderPrize.isSamePosition(position))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("LadderPrizes가 잘못된 값을 받았습니다."));
    }

    public Stream<LadderPrize> stream() {
        return ladderPrizes.stream();
    }
}
