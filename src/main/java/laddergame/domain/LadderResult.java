package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResult {
    private final List<LadderResultItem> resultItems;

    private LadderResult(final List<String> resultNames) {
        resultItems = new ArrayList<>();

        for (final String resultName : resultNames) {
            resultItems.add(new LadderResultItem(resultName));
        }
    }

    public static LadderResult of(Participants participants, List<String> resultNames) {
        if (participants.getSize() != resultNames.size()) {
            throw new IllegalArgumentException("인원수과 결과의 개수가 일치하지 않습니다.");
        }
        return new LadderResult(resultNames);
    }

    public List<String> getItemNames() {
        return resultItems.stream().map(LadderResultItem::getName).collect(Collectors.toUnmodifiableList());
    }
}
