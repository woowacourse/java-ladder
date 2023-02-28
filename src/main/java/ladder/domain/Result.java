package ladder.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Result {

    private final String NOT_FOUND_VALUE_BY_KEY = "[ERROR] 해당 Key는 존재하지 않습니다.";

    private final HashMap<String, String> result;

    public Result() {
        this.result = new LinkedHashMap<>();
    }

    public void add(final String key, final String value) {
        result.put(key, value);
    }

    public String get(final String key) {
        if (!result.containsKey(key)) {
            throw new IllegalArgumentException(NOT_FOUND_VALUE_BY_KEY);
        }
        return result.get(key);
    }

    public HashMap<String, String> result() {
        return (LinkedHashMap<String, String>) result.clone();
    }
}
