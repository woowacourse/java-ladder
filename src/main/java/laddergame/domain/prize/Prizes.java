package laddergame.domain.prize;

import java.util.List;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;

public class Prizes {

    private final List<Prize> prizes;

    public Prizes(final List<String> prizeNames, final int size) {
        validatePrizeSize(prizeNames, size);

        this.prizes = createPrizes(prizeNames);
    }

    private void validatePrizeSize(final List<String> prizeNames, final int size) {
        if (isDifferentSize(prizeNames, size)) {
            throw new IllegalArgumentException("결과의 수는 참여할 사람 수와 맞아야 합니다.");
        }
    }

    private static boolean isDifferentSize(final List<String> prizeNames, final int size) {
        return prizeNames.size() != size;
    }

    private List<Prize> createPrizes(final List<String> prizeNames) {
        return prizeNames.stream()
                .map(Prize::new)
                .collect(toList());
    }

    public Prize getPrize(final int index) {
        return prizes.get(index);
    }

    public List<Prize> getPrizes() {
        return unmodifiableList(prizes);
    }

    public int getMaxPrizeLength() {
        return prizes.stream()
                .mapToInt(prize -> prize.getPrize().length())
                .max()
                .orElseThrow(() -> new IllegalStateException("이름의 길이 최대값의 찾을 수 없습니다."));
    }
}
