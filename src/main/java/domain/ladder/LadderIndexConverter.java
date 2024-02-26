package domain.ladder;

import dto.RowPatternDto;
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
        return mappedIndex.get(playerIndex);
    }

    public void swapByRowPattern(RowPatternDto rowPatternDto) {
    }

    private void swapWithRightIndex(int index) {
    }
}
