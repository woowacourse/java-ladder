package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class ResultItems {
    private List<ResultItem> resultItems = new ArrayList<>();

    public ResultItems(List<String> resultItemNames, int numberOfPlayer) {
        validateNumberOfResultItems(resultItemNames.size(), numberOfPlayer);
        for (String resultItemName : resultItemNames) {
            resultItems.add(new ResultItem(resultItemName));
        }
    }

    public List<ResultItem> getResultItems() {
        return resultItems;
    }

    private void validateNumberOfResultItems(int size, int numberOfPlayer) {
        if (size != numberOfPlayer) {
            throw new IllegalArgumentException("당첨 상품의 수는 플레이어의 수와 같아야 합니다.");
        }
    }

    public ResultItem answerMatchItemOf(int playerPosition) {
        return resultItems.get(playerPosition);
    }
}
