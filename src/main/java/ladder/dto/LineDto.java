package ladder.dto;

import java.util.List;
import java.util.stream.IntStream;
import ladder.domain.ladder.Ladder;

public record LineDto(List<Boolean> sticks) {

    public static LineDto of(Ladder ladder, int height) {
        List<Boolean> sticks = IntStream.range(0, ladder.getWidth())
                .mapToObj(width -> ladder.isExist(height, width))
                .toList();
        return new LineDto(sticks);
    }
}
