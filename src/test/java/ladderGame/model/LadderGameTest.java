package ladderGame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderGameTest {

    @Test
    @DisplayName("참여자 이름을 통해 사다리 결과를 알려준다.")
    void findLadderGameResult() {
        LineGenerator lineGenerator = new LineGenerator(() -> true);
        List<Line> lines = Stream.generate(() -> new Line(lineGenerator.makeLine(3)))
                .limit(4)
                .toList();

        Ladder ladder = new Ladder(new ArrayList<>(lines));

        LadderGame ladderGame = new LadderGame(new Players(List.of("포비", "왼손", "준")), new LadderResults(List.of("꽝", "5000", "3000")), ladder);

        assertAll(
                () -> assertEquals(ladderGame.findLadderGameResult("포비"), new LadderResult("꽝")),
                () -> assertEquals(ladderGame.findLadderGameResult("왼손"), new LadderResult("5000")),
                () -> assertEquals(ladderGame.findLadderGameResult("준"), new LadderResult("3000"))
        );
    }

}
