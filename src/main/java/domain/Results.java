package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private static final String DELIMITER = ",";

    private final List<Result> results;

    public Results(String result, People people) {
        this.results = validateAndGet(result.split(DELIMITER), people);
    }

    private List<Result> validateAndGet(String[] stringArray, People people) {
        if (stringArray.length != people.getCount()) {
            throw new IllegalArgumentException("실행 결과의 수는 사람 수와 같아야 합니다");
        }
        return Arrays.stream(stringArray)
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public Result getByIndex(Position position) {
        return results.get(position.getColumn());
    }
}
