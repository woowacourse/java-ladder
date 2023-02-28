package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningPrizes {

    private final List<WinningPrize> winningPrizes;

    private WinningPrizes(final List<WinningPrize> winningPrizes) {
        this.winningPrizes = winningPrizes;
    }

    public static WinningPrizes of(final List<String> prizes, final int playerCount) {
        validateSize(prizes, playerCount);
        final List<WinningPrize> winningPrizes = createWinningPrizes(prizes, playerCount);

        return new WinningPrizes(winningPrizes);
    }

    public int findMaxNameLength() {
        return winningPrizes.stream()
                .mapToInt(WinningPrize::getWinningPrizeLength)
                .max()
                .orElseThrow(() -> new IllegalStateException("가장 긴 상품을 찾을 수 없습니다."));
    }

    private static List<WinningPrize> createWinningPrizes(final List<String> prizes, final int playerCount) {
        final List<WinningPrize> winningPrizes = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            final WinningPrize winningPrize = new WinningPrize(prizes.get(i));
            winningPrizes.add(winningPrize);
        }
        return winningPrizes;
    }

    private static void validateSize(final List<String> winningPrizes, final int playerCount) {
        if (winningPrizes.size() != playerCount) {
            throw new IllegalArgumentException("실행 결과수가 플레이어수와 일치하지 않습니다.");
        }
    }

    public List<WinningPrize> getWinningPrizes() {
        return Collections.unmodifiableList(winningPrizes);
    }

    public WinningPrize getIndexPrize(final int index) {
        return winningPrizes.get(index);
    }
}
