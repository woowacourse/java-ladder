package ladder.domain;

import ladder.util.InputHelper;

import java.util.LinkedHashMap;
import java.util.Objects;

public class RewardPersonConnector {
    private final LinkedHashMap<String, String> nameToResult = new LinkedHashMap<>();

    public RewardPersonConnector(Ladder ladder, LadderGameData ladderGameData) {
        for (int i = 0; i < ladderGameData.getPerson().getCountOfPerson(); i++) {
            nameToResult.put(ladderGameData.getPerson().getName(i), ladderGameData.getLadderRewards().getResult(ladder.moveStartToEnd(i + 1) - 1));
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
            sb.append(name).append(" : ").append(nameToResult.get(name)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RewardPersonConnector that = (RewardPersonConnector) o;
        return Objects.equals(nameToResult, that.nameToResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameToResult);
    }
}
