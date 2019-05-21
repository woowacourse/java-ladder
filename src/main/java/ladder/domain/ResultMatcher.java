package ladder.domain;

import ladder.util.InputHelper;

import java.util.ArrayList;
import java.util.List;

import java.util.LinkedHashMap;
import java.util.Objects;

public class ResultMatcher {
    private final LinkedHashMap<String, String> nameToResult = new LinkedHashMap<>();

    public ResultMatcher(Ladder ladder, LadderGameData ladderGameData) {
        List<Integer> allResult = generateAllResults(ladder, ladderGameData);
        for (int i = 0; i < allResult.size(); i++) {
            nameToResult.put(ladderGameData.getPerson().getName(i), ladderGameData.getResult().getResult(allResult.get(i) - 1));
        }
    }

    private List<Integer> generateAllResults(Ladder ladder, LadderGameData ladderGameData) {
        List<Integer> resultIndex = new ArrayList<>();
        for (int i = 0; i < ladderGameData.getPerson().getCountOfPerson(); i++) {
            resultIndex.add(ladder.move(i + 1));
        }
        return resultIndex;
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
        ResultMatcher that = (ResultMatcher) o;
        return Objects.equals(nameToResult, that.nameToResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameToResult);
    }
}
