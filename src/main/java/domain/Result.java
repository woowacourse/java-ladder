package domain;

import java.util.Map;

public class Result {
    private final Map<String, String> results;

    public Result(Map<String, String> results) {
        this.results = results;
    }

    public String getResultByPerson(String name) {
        validateName(name);
        return results.get(name);
    }

    private void validateName(String name) {
        if (!results.containsKey(name)) {
            throw new IllegalArgumentException("이름은 이전에 입력한 이름 중에 하나여야 합니다.");
        }
    }
}
