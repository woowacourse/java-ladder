package domain.ladder;

import dto.RowPatternDto;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderIndexConverter {

    private final List<Integer> mappedIndex;

    public LadderIndexConverter(int playerCount) {
        this.mappedIndex = IntStream.range(0, playerCount)
                .boxed()
                .collect(Collectors.toList());
    }

    public int getMappedIndexByPlayerIndex(int playerIndex) {
        validateIndex(playerIndex);
        return mappedIndex.get(playerIndex);
    }

    public void swapByRowPattern(RowPatternDto rowPatternDto) {
        List<Boolean> rowPattern = rowPatternDto.rowPattern();
        validateRowPatternSize(rowPattern);
        IntStream.range(0, rowPattern.size())
                .filter(rowPattern::get)
                .forEach(this::swapWithRightIndex);
    }

    private void swapWithRightIndex(int index) {
        Collections.swap(mappedIndex, index, index + 1);
    }

    private void validateIndex(int playerIndex) {
        if (playerIndex < 0 || playerIndex >= mappedIndex.size()) {
            throw new IndexOutOfBoundsException("주어진 인덱스가 매핑 범위를 벗어납니다.");
        }
    }

    private void validateRowPatternSize(List<Boolean> rowPattern) {
        if (rowPattern.size() != mappedIndex.size() - 1) {
            throw new IndexOutOfBoundsException("주어진 사다리 패턴의 크기가 올바르지 않습니다.");
        }
    }
}
