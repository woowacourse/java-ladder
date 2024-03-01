package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultItems {

    private final List<ResultItem> resultItems;

    public ResultItems(int personCount, String... strings) {
        this(personCount, Arrays.asList(strings));
    }

    public ResultItems(int personCount, List<String> rawResultItems) {
        List<ResultItem> resultItems = createResultItems(rawResultItems);
        validate(personCount, resultItems);
        this.resultItems = new ArrayList<>(resultItems);
    }

    private List<ResultItem> createResultItems(List<String> rawResultItems) {
        return rawResultItems.stream()
                .map(ResultItem::new)
                .toList();
    }

    private void validate(int personCount, List<ResultItem> resultItems) {
        validateSize(personCount, resultItems);
    }

    private void validateSize(int personCount, List<ResultItem> resultItems) {
        if (personCount != resultItems.size()) {
            throw new IllegalArgumentException("결과 항목 수가 참여자 수와 같아야 합니다.");
        }
    }

    public ResultItem get(Index index) {
        return resultItems.get(index.getValue());
    }

    public List<String> getRawResultItems() {
        return resultItems.stream()
                .map(ResultItem::getValue)
                .toList();
    }
}
