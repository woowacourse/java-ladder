package ladderGame.model;

import java.util.ArrayList;
import java.util.List;

public class Prizes {
    private static final String EXCEPTION_MESSAGE_INCORRECT_PRIZE_COUNT = "실행 결과의 수는 참가자의 수와 일치해야 합니다.";

    private final List<Prize> prizes;

    public Prizes(List<String> prizes, int playersCount) {
        validate(prizes.size(), playersCount);
        this.prizes = prizes.stream()
                .map(Prize::new)
                .toList();
    }

    private void validate(int prizesCount, int playersCount) {
        if(prizesCount != playersCount) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_INCORRECT_PRIZE_COUNT);
        }
    }

    public List<Prize> getPrizes() {
        return new ArrayList<>(prizes);
    }
}
