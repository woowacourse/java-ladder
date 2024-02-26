package domain;

import java.util.Arrays;
import java.util.List;

public class Results {

    private final List<Result> results;

    private Results(int membersCount, List<Result> results) {
        validate(membersCount, results);
        this.results = results;
    }

    public static Results from(int membersCount, String rawNames) {
        validateNull(rawNames);
        return new Results(membersCount, initialize(rawNames));
    }

    private void validate(int membersCount, List<Result> results) {
        if (membersCount != results.size()) {
            throw new IllegalArgumentException("플레이어 수만큼 입력해주세요.");
        }
    }

    private static void validateNull(String rawNames) {
        if (rawNames == null) {
            throw new IllegalArgumentException("null을 입력할 수 없습니다.");
        }
    }

    private static List<Result> initialize(String rawNames) {
        return Arrays.stream(rawNames.split("\\s*,\\s*", -1))
            .map(String::trim)
            .map(Result::from)
            .toList();
    }

    public List<String> getNames() {
        return results.stream()
            .map(Result::getName)
            .toList();
    }
}
