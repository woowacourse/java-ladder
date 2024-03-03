package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes {

    private final List<Prize> prizes;

    public Prizes(Players players, List<String> inputPrizes) {
        validate(players, inputPrizes);

        this.prizes = inputPrizes.stream()
                .map(Prize::new)
                .collect(Collectors.toList());
    }

    private void validate(Players players, List<String> inputPrizes) {
        if (players.getTotalPlayerSize() != inputPrizes.size()) {
            throw new IllegalArgumentException(
                    String.format("입력한 결과의 수는 플레이어의 수와 일치해야 합니다. 입력한 결과 수: %d", inputPrizes.size()));
        }
    }

    public Prize getPrizeIndexOf(int index) {
        return prizes.get(index);
    }

    public List<Prize> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }
}
