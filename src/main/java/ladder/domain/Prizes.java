package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Prizes {
    private static final String DIFFERENT_COUNT = "보상 개수가 사람의 수와 다릅니다.";
    private final List<String> values;

    private Prizes(List<String> values, int count) {
        this.values = new ArrayList<>(values);
        validateCount(this.values, count);
    }

    public static Prizes from(List<String> prizes, int count) {
        return new Prizes(prizes.stream()
                .map(String::strip)
                .toList(), count);
    }

    private void validateCount(List<String> values, int count) {
        if (values.size() != count) {
            throw new IllegalArgumentException(DIFFERENT_COUNT);
        }
    }

    public List<String> getNames() {
        return List.copyOf(values);
    }
}
