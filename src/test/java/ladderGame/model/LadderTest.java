package ladderGame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사용자의 사다리 시작 위치를 통해 사다리 결과 위치를 알려준다.")
    void findLadderResultIndex() {
        LineGenerator lineGenerator = new LineGenerator(() -> true);
        List<Line> lines = Stream.generate(() -> new Line(lineGenerator.makeLine(3)))
                .limit(4)
                .toList();

        Ladder ladder = new Ladder(new ArrayList<>(lines));

        assertAll(
                () -> assertEquals(ladder.findLadderResultIndex(0), 0),
                () -> assertEquals(ladder.findLadderResultIndex(1), 1),
                () -> assertEquals(ladder.findLadderResultIndex(2), 2)
        );
    }
}
