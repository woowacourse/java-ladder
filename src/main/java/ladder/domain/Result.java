package ladder.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ResultStorage {
    private final Map<String, String> result;

    public ResultStorage() {
        result = new LinkedHashMap<>();
    }

    public void add(final String result) {
        resultStorage.add(result);
    }

    public String get(final int index) {
        if (resultStorage.size() <= index) {
            throw new IllegalArgumentException();
        }
        return resultStorage.get(index);
    }

    public List<String> getAll() {
        return List.copyOf(resultStorage);
    }
}
