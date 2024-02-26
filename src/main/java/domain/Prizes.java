package domain;

import java.util.List;

public class Prizes {

    private final List<String> prizes;

    public Prizes(List<String> prizes, int numberOfPrize) {
        validateNumberOfPrize(prizes, numberOfPrize);
        this.prizes = prizes;
    }

    void validateNumberOfPrize(List<String> prizes, int numberOfPrize) {
        if (prizes.size() != numberOfPrize) {
            throw new IllegalArgumentException("결과의 개수가 참여자의 인원수와 다릅니다.");
        }
    }

    String getPrizeOf(int indexOfPrize) {
        return prizes.get(indexOfPrize);
    }
}
