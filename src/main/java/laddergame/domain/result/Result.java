package laddergame.domain.result;

import laddergame.util.InputValidator;

import java.util.Map;

public class Result {
    private final Map<String, String> result;

    public Result(final Map<String, String> result) {
        this.result = result;
    }

    public String findByName(final String name) {
        InputValidator.validateBlank(name);

        if (!result.containsKey(name)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 참가자이름입니다.");
        }

        return result.get(name);
    }

    public Map<String, String> getResult() {
        return result;
    }
}
