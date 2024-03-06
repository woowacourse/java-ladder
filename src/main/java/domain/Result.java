package domain;

import java.util.List;
import java.util.stream.IntStream;

public class Result {

    public static final String NOT_SAME_COUNT = "[ERROR] 결과의 개수가 참여자의 인원수와 다릅니다.";

    private final List<Prize> prizes;

    public Result(List<String> prizes, int numberOfPrize) {
        validateNumberOfPrize(prizes, numberOfPrize);
        this.prizes = IntStream.range(0, numberOfPrize)
                .mapToObj(i -> new Prize(prizes.get(i), i))
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
        return prizes.stream()
                .filter(prize -> prize.getPosition() == position)
                .findFirst()
                .get();
    }
}
