package ladderGame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderGameTest {

    private LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        List<Line> lines = Stream.generate(() -> new Line(List.of(ConnectionStatus.CONNECTION, ConnectionStatus.DISCONNECTION)))
                .limit(4)
                .toList();

        Ladder ladder = new Ladder(new ArrayList<>(lines));

        ladderGame = new LadderGame(new Players(List.of("포비", "왼손", "준")), new LadderResults(List.of("꽝", "5000", "3000")), ladder);

        /*
        포비   왼손     준
           |-----|     |
           |-----|     |
           |-----|     |
           |-----|     |
          꽝  5000  3000
         */
    }

    @Test
    @DisplayName("참여자 이름을 통해 사다리 결과를 알려준다.")
    void findLadderGameResult() {
        assertAll(
                () -> assertEquals(ladderGame.findLadderGameResult("포비"), new LadderResult("꽝")),
                () -> assertEquals(ladderGame.findLadderGameResult("왼손"), new LadderResult("5000")),
                () -> assertEquals(ladderGame.findLadderGameResult("준"), new LadderResult("3000"))
        );
    }

    @Test
    @DisplayName("모든 참여자의 결과를 알려준다.")
    void findAllLadderGameResults() {
        Map<Player, LadderResult> results = ladderGame.findAllLadderGameResults();
        List<String> printResult = List.of("포비 : 꽝", "왼손 : 5000", "준 : 3000");

        for (Player player : results.keySet()) {
            assertThat(String.format(player.getName() + " : " + results.get(player).getLadderResult()))
                    .isIn(printResult);
        }
    }

    @Test
    @DisplayName("사다리 결과 수가 참여자 수와 동일하지 않을 시 예외가 발생합니다.")
    void validateCounts() {
        List<Line> lines = Stream.generate(() -> new Line(List.of(ConnectionStatus.CONNECTION, ConnectionStatus.DISCONNECTION)))
                .limit(4)
                .toList();

        Ladder ladder = new Ladder(new ArrayList<>(lines));

        assertThatThrownBy(() -> new LadderGame(new Players(List.of("포비", "왼손", "준")), new LadderResults(List.of("꽝", "5000")), ladder))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
