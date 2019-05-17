package ladder.domain;

import java.util.*;

public class LadderResult {
    private final LinkedHashMap<String, String> nameToResult = new LinkedHashMap<>();

    public LadderResult(List<Integer> allResult, List<String> names, List<String> resultCandidate) {
        for (int i = 0; i < allResult.size(); i++) {
            String name = names.get(i);
            String result = resultCandidate.get(allResult.get(i) - 1);
            nameToResult.put(name, result);
        }
    }

    public String matchResult(String requestedName) {
        if (requestedName.equals("all")) {
            return makeAllResult();
        }
        return nameToResult.get(requestedName);
    }

    private String makeAllResult() {
        StringBuilder sb = new StringBuilder();

        for (String name : nameToResult.keySet()) {
            sb.append(makeResult(name));
        }
        return sb.toString();
    }

    private String makeResult(String name) {
        return name + " : " + nameToResult.get(name) + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(nameToResult, that.nameToResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameToResult);
    }
}
