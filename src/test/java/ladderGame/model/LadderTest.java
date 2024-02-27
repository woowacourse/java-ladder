package ladderGame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderTest {

    @Test
    @DisplayName("사용자의 사다리 시작 위치를 통해 사다리 결과 위치를 알려준다.")
    void findLadderResultPosition() {
        List<Line> lines = Stream.generate(() -> new Line(List.of(ConnectionStatus.CONNECTION, ConnectionStatus.DISCONNECTION)))
                .limit(4)
                .toList();

        Ladder ladder = new Ladder(new ArrayList<>(lines));

        /*
           |-----|     |
           |-----|     |
           |-----|     |
           |-----|     |
        */

        assertAll(
                () -> assertEquals(ladder.findLadderResultPosition(0), 0),
                () -> assertEquals(ladder.findLadderResultPosition(1), 1),
                () -> assertEquals(ladder.findLadderResultPosition(2), 2)
        );
    }
}
