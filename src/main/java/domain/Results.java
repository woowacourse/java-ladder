package domain;

import java.util.List;

public class Results {

    List<Result> prizes;

    private Results(final List<Result> prizes) {
        this.prizes = prizes;
    }

    public static Results of(final List<Result> prizes, final int personCount) {
        validate(prizes.size(), personCount);
        return new Results(prizes);
    }

    private static void validate(final int prizeCount, final int personCount) {
        if (personCount != prizeCount) {
            throw new IllegalArgumentException(String.format("입력된 값: %d, 사용자 수와 실행 결과 수는 같아야 합니다.", personCount));
        }
    }

    public List<String> getPrizeNames() {
        return prizes.stream()
                .map(Result::toString)
                .toList();
    }

    public Result getFirst() {
        return prizes.get(0);
    }

    public Result getLast() {
        return prizes.get(prizes.size() - 1);
    }

    public List<Result> getMiddleResult() {
        return prizes.subList(1, prizes.size() - 1);
    }
}
