package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {
    private final List<LadderResultItem> resultItems;

    private LadderResult(final List<String> resultNames) {
        resultItems = new ArrayList<>();

        for (final String resultName : resultNames) {
            resultItems.add(new LadderResultItem(resultName));
        }
    }

    public static LadderResult of(PersonalNames personalNames, List<String> resultNames) {
        if (personalNames.getSize() != resultNames.size()) {
            throw new IllegalArgumentException("인원수과 결과의 개수가 일치하지 않습니다.");
        }
        return new LadderResult(resultNames);
    }

    public List<LadderResultItem> getResultItems() {
        return resultItems;
    }
}
