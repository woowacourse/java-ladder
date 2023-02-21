package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class ResultStorage {
    private final List<String> resultStorage;

    public ResultStorage() {
        resultStorage = new ArrayList<>();
    }

    public void add(String result) {
        resultStorage.add(result);
    }

    public String get(int index) {
        if(resultStorage.size() <= index) {
            throw new IllegalArgumentException();
        }
        return resultStorage.get(index);
    }

    public List<String> getAll() {
        return List.copyOf(resultStorage);
    }
}
