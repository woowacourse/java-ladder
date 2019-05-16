package ladder.domain;

import java.util.ArrayList;
import java.util.List;

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
}
