package domain.result;

import java.util.List;

public class Prizes {
    private static final int MIN_RESULT_SIZE = 2;

    private final List<Prize> prizes;

    public Prizes(List<String> resultNames) {
        validate(resultNames);
        this.prizes = resultNames.stream()
                .map(String::strip)
                .map(Prize::new)
                .toList();
    }

    private void validate(List<String> resultNames) {
        if (resultNames.size() < MIN_RESULT_SIZE) {
            throw new IllegalArgumentException("결과는 " + MIN_RESULT_SIZE + " 개 이상으로 구성되어야 합니다.");
        }
    }

    public Prize get(int index) {
        return prizes.get(index);
    }

    public int size() {
        return prizes.size();
    }

    public List<String> getResults() {
        return prizes.stream()
                .map(Prize::getPrizeName)
                .toList();
    }
}
