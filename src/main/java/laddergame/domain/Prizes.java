package laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Prizes {

    private final List<Prize> prizes;

    public Prizes(List<String> values, int playersCount) {
        List<Prize> prizes = values.stream()
                .map(value -> new Prize(value))
                .collect(Collectors.toList());
        validatePrizes(prizes, playersCount);
        this.prizes = List.copyOf(prizes);
    }

    private void validatePrizes(List<Prize> prizes, int playersCount) {
        if (prizes.size() != playersCount) {
            throw new IllegalArgumentException("[ERROR] 사다리 상품의 개수가 플레이어의 수와 동일하지 않습니다.");
        }
    }

    public int size() {
        return prizes.size();
    }

    public String get(int position) {
        return prizes.get(position).getPrize();
    }
}
