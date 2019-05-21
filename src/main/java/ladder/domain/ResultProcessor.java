package ladder.domain;

import ladder.util.InputHelper;

import java.util.List;

import java.util.LinkedHashMap;
import java.util.Objects;

public class ResultProcessor {
    private final LinkedHashMap<String, String> nameToResult = new LinkedHashMap<>();

    ResultProcessor(List<Integer> allResult, LadderGameData ladderGameData) {
        for (int i = 0; i < allResult.size(); i++) {
            nameToResult.put(ladderGameData.getPerson().getName(i), ladderGameData.getResult().getResult(allResult.get(i) - 1));
        }
    }

    public String getResult(String requestedName) {
        if (InputHelper.isAll(requestedName)) {
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
