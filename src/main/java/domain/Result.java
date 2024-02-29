package domain;

import constant.domain.ResultExceptionMessage;

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
            throw new IllegalArgumentException(ResultExceptionMessage.NOT_SAME_COUNT.getExceptionMessage());
        }
    }

    public List<Prize> getPrizes() {
        return prizes;
    }
}
