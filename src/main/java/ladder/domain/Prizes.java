package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Prizes {

    private final List<Prize> prizes;

    public Prizes(final List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes from(final List<String> names, final Players players) {
        final Prizes prizes = new Prizes(generatePrizes(names));
        validateSameSize(prizes, players);
        return prizes;
    }

    private static List<Prize> generatePrizes(final List<String> names) {
        return names.stream()
                .map(Prize::new)
                .collect(Collectors.toList());
    }

    private static void validateSameSize(final Prizes prizes, final Players players) {
        if (players.size() != prizes.size()) {
            throw new IllegalArgumentException(
                    "실행 결과 개수는 플레이어 수와 동일해야 합니다. 플레이어 수: " + players.size() + ", 실행 결과 개수: " + prizes.size());
        }
    }

    public String check(final int position) {
        return prizes.get(position).getValue();
    }

    public List<String> getPrizeNames() {
        return prizes.stream()
                .map(Prize::getValue)
                .collect(Collectors.toList());
    }

    public int size() {
        return prizes.size();
    }
}
