package domain;

import java.util.List;

public class Result {

    private final List<Prize> prizes;

    public Result(List<String> prizes, int numberOfPrize) {
        validateNumberOfPrize(prizes, numberOfPrize);
        this.prizes = prizes.stream()
                .map(Prize::new)
                .toList();
    }

    void validateNumberOfPrize(List<String> prizes, int numberOfPrize) {
        if (prizes.size() != numberOfPrize) {
            throw new IllegalArgumentException("결과의 개수가 참여자의 인원수와 다릅니다.");
        }
    }

    String getPrizeOf(int indexOfPrize) {
        return prizes.get(indexOfPrize).getPrize();
    }

    public List<Prize> getPrizes() {
        return prizes;
    }
}
