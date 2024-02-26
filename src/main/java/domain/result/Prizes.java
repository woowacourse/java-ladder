package domain.result;

import java.util.List;

public class Prizes {
    private static final int MIN_RESULT_SIZE = 2;

    private final List<Prize> prizes;

    public Prizes(List<String> resultNames) {
        validate(resultNames);
        this.prizes = resultNames.stream()
                .map(Prize::new)
                .toList();
    }

    private void validate(List<String> resultNames) {
        if (resultNames.size() < MIN_RESULT_SIZE) {
            throw new IllegalArgumentException("결과는 " + MIN_RESULT_SIZE + " 개 이상으로 구성되어야 합니다.");
        }
    }

    public int size() { // TODO : 얘가 정말 필요한 메서드인가?
        return prizes.size();
    }

    public Prize get(int index) {
        return prizes.get(index);
    }

    public List<String> getResults() {
        return prizes.stream()
                .map(result -> result.getResultName())
                .toList();
    }
}
