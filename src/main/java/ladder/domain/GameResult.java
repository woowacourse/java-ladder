package ladder.domain;

import java.util.List;

import java.util.LinkedHashMap;
import java.util.Objects;

public class GameResult {
    private static String NOT_CONTAIN_NAME_MESSAGE = "없는 이름입니다.";
    private final LinkedHashMap<String, String> nameToResult;

    private GameResult(final LinkedHashMap<String, String> nameToResult) {
        this.nameToResult = nameToResult;
    }

    static GameResult generateGameResult(List<Integer> allResult, Person person, Result result) {
        LinkedHashMap<String, String> nameToResult = new LinkedHashMap<>();
        for (int i = 0; i < allResult.size(); i++) {
            nameToResult.put(person.getName(i), result.getResult(allResult.get(i) - 1));
        }
        return new GameResult(nameToResult);
    }

    public String getGameResult(String requestedName, Person person) {
        isNotContainName(person, requestedName);
        if (requestedName.equals("all")) {
            return getAllResults();
        }
        return nameToResult.get(requestedName);
    }

    private void isNotContainName(Person person, String requestedName) {
        if (!requestedName.equals("all") && !person.findName(requestedName)) {
            throw new IllegalArgumentException(NOT_CONTAIN_NAME_MESSAGE);
        }
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
