package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private static final String DELIMITER = ",";

    private final List<Result> results;

    public Results(String result, int count) {
        this.results = validateAndGet(result.split(DELIMITER), count);
    }

    private List<Result> validateAndGet(String[] stringArray, int count) {
        if (stringArray.length != count) {
            throw new IllegalArgumentException("실행 결과의 수는 사람 수와 같아야 합니다");
        }
        return Arrays.stream(stringArray)
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public Result getByIndex(int index) {
        return results.get(index);
    }
}
