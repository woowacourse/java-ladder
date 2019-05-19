package ladder.domain;

import java.util.List;

import java.util.LinkedHashMap;
import java.util.Objects;

public class GameResult {
    private final LinkedHashMap<String, String> nameToResult = new LinkedHashMap<>();

    GameResult(List<Integer> allResult, Person person, Result result) {
        for (int i = 0; i < allResult.size(); i++) {
            nameToResult.put(person.getName(i), result.getResult(allResult.get(i) - 1));
        }
    }

    public String getResult(String requestedName) {
        if (requestedName.equals("all")) {
            return getAllResults();
        }
        return nameToResult.get(requestedName);
    }

    private String getAllResults() {
        StringBuilder sb = new StringBuilder();
        for (String name : nameToResult.keySet()) {
            sb.append(name + " : " + nameToResult.get(name) + "\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(nameToResult, that.nameToResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameToResult);
    }
}
