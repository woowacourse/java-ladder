package domain;

import java.util.List;

public class Result {

    public static final String NOT_SAME_COUNT = "[ERROR] 결과의 개수가 참여자의 인원수와 다릅니다.";

    private final List<Prize> prizes;

    public Result(List<String> prizes, int numberOfPrize) {
        validateNumberOfPrize(prizes, numberOfPrize);
        this.prizes = prizes.stream()
                .map(Prize::new)
                .toList();
    }

    void validateNumberOfPrize(List<String> prizes, int numberOfPrize) {
        if (prizes.size() != numberOfPrize) {
            throw new IllegalArgumentException(NOT_SAME_COUNT);
        }
    }

    public List<Prize> getPrizes() {
        return prizes;
    }

    public Prize getPrizeOf(Position position) {
        return prizes.get(position.getPosition());
    }
}
