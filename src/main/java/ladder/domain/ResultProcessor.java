package ladder.domain;

import java.util.List;

import java.util.LinkedHashMap;
import java.util.Objects;

public class ResultProcessor {
    private static final String FOR_ALL_RESULT = "all";
    private final LinkedHashMap<String, String> nameToResult = new LinkedHashMap<>();

    ResultProcessor(List<Integer> allResult, Person person, Result result) {
        for (int i = 0; i < allResult.size(); i++) {
            nameToResult.put(person.getName(i), result.getResult(allResult.get(i) - 1));
        }
    }

    public String getResult(String requestedName) {
        if (requestedName.equals(FOR_ALL_RESULT)) {
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
        ResultProcessor that = (ResultProcessor) o;
        return Objects.equals(nameToResult, that.nameToResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameToResult);
    }
}
