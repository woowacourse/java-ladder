package laddergame.domain;

import laddergame.constant.ErrorMessage;

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
            throw new IllegalArgumentException(ErrorMessage.NOT_SAME_COUNT.getMessage());
        }
    }

    public int size() {
        return prizes.size();
    }

    public List<String> getPrizes() {
        return prizes.stream()
                .map(Prize::getPrize)
                .collect(Collectors.toList());
    }

    public String get(int position) {
        return prizes.get(position).getPrize();
    }
}
