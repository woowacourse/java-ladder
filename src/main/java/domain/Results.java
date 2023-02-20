package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private static final String DELIMITER = ",";

    private final List<String> results;

    public Results(String result, int count) {
        this.results = validateAndGet(result.split(DELIMITER), count);
    }

    private List<String> validateAndGet(String[] stringArray, int count) {
        if (stringArray.length != count) {
            throw new IllegalArgumentException("실행 결과의 수는 사람 수와 같아야 합니다");
        }
        return Arrays.stream(stringArray)
                .collect(Collectors.toList());
    }

    public String getByIndex(int index) {
        return results.get(index);
    }
}
