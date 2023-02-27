package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;

    public Results(String resultValuesRaw, int size) {
        List<String> resultValues = splitResultValuesRaw(resultValuesRaw);
        validateSize(resultValues, size);
        this.results = generateResultsByRaw(resultValues);
    }

    public List<String> getContents() {
        return this.results.stream()
                .map(Result::content)
                .collect(Collectors.toList());
    }

    private List<String> splitResultValuesRaw(String resultValuesRaw) {
        return Arrays.stream(resultValuesRaw.split(","))
                .collect(Collectors.toList());
    }

    private void validateSize(List<String> resultValues, int size) {
        if (resultValues.size() != size) {
            throw new IllegalArgumentException("플레이어의 수와 결과의 수가 다릅니다.");
        }
    }

    private List<Result> generateResultsByRaw(List<String> resultValues) {
        return resultValues.stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public Result getResultByIndex(int columnIndex) {
        return this.results.get(columnIndex);
    }
}
