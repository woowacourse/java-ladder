package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LadderGameTest {

    @DisplayName("객체가 제대로 생성된 경우 게임 결과를 맵 형태로 반환한다.")
    @Test
    void successCreate() {
        Participants participants = new Participants("pobi,honux,crong,jk");
        List<Line> lines = IntStream.range(0, 3)
                                    .mapToObj((count) -> new Line(3, () -> true))
                                    .collect(Collectors.toList());
        Ladder ladder = new Ladder(lines);
        Results results = new Results("a,b,c,d", 4);

        LadderGame ladderGame = new LadderGame(participants, ladder, results);
        Assertions.assertThat(ladderGame.getResult())
                  .containsEntry("pobi", "b")
                  .containsEntry("honux", "a")
                  .containsEntry("crong", "d")
                  .containsEntry("jk", "c");
    }
}
