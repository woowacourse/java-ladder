package ladder.domain;

import java.util.*;

public class ResultItems {
    List<ResultItem> resultItems = new ArrayList<>();

    public ResultItems(List<String> itemNames, int numberOfPlayers) {
        if (itemNames.size() != numberOfPlayers) {
            throw new IllegalArgumentException("당첨 상품의 수는 플레이어의 수와 같아야 합니다.");
        }
        for (String itemName : itemNames) {
            resultItems.add(new ResultItem(itemName));
        }
    }

    public HashMap<String, ResultItem> makeLaddringResult(PlayerGroup players) {
        HashMap<String, ResultItem> ladderingResult = new LinkedHashMap<>();

        for (Player player : players.getPlayers()) {
            ladderingResult.put(player.getName(), resultItems.get(player.getPosition()));
        }

        return ladderingResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultItems that = (ResultItems) o;
        return Objects.equals(resultItems, that.resultItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultItems);
    }

    public List<ResultItem> getResultItems() {
        return resultItems;
    }
}
