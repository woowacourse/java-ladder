package domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderIndexConverter {

    private final List<Integer> resultIndex;

    public LadderIndexConverter(int playerCount) {
        this.resultIndex = IntStream.range(0, playerCount)
                .boxed()
                .collect(Collectors.toList());
    }

    public void swapByRowPattern(List<Boolean> rowPattern) {
        validateRowPatternSize(rowPattern);
        IntStream.range(0, rowPattern.size())
                .filter(rowPattern::get)
                .forEach(this::swapWithRightIndex);
    }

    List<Integer> getResultIndex() {
        return Collections.unmodifiableList(resultIndex);
    }

    private void swapWithRightIndex(int index) {
        Collections.swap(resultIndex, index, index + 1);
    }

    private void validateRowPatternSize(List<Boolean> rowPattern) {
        if (rowPattern.size() != resultIndex.size() - 1) {
            throw new IndexOutOfBoundsException("주어진 사다리 패턴의 크기가 올바르지 않습니다.");
        }
    }
}
