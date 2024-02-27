package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Result {

    private final List<ResultItem> resultItems;

    public Result(List<ResultItem> resultItems) {
        this.resultItems = new ArrayList<>(resultItems);
    }

    public void calculateNext(Line line) {
        List<Integer> usedPointIndexes = line.findUsedPointIndexes();
        for (int index : usedPointIndexes) {
            Collections.swap(resultItems, index, index + 1);
        }
    }

    public List<ResultItem> getResultItems() {
        return Collections.unmodifiableList(resultItems);
    }

}
