package domain;

import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static util.Connection.CONNECTED;
import static util.Connection.UNCONNECTED;

public class LadderGameTest {

    private LadderGame ladderGame;

    @BeforeEach
    void setLadderGame() {
        Ladder ladder = new Ladder(List.of(
                new Line(List.of(4, 5))
        ));
        ladderGame = new LadderGame(
                new PlayerNames(List.of("a", "b")),
                new WinningNames(List.of("1", "2"), 2),
                ladder,
                new CustomGenerator(List.of(false, true))
        );
    }

    @DisplayName("입력받은 이름과 사다리 높이에 따른 결과를 String으로 반환한다.")
    @Test
    void getResultTest() {
        Assertions.assertThat(ladderGame.getLadderSequence())
                .isEqualTo(List.of(
                        "     a     b",
                        UNCONNECTED.getBridge() + CONNECTED.getBridge(),
                        "     1     2"
                ));
    }

    @DisplayName("라인들을 순회하며 연결된 인덱스의 List<Name>을 swap한 결과를 Map으로 반환한다.")
    @Test
    void swapForConnected() {
        Assertions.assertThat(ladderGame.getResult())
                .isEqualTo(Map.of("a", "2", "b", "1"));
    }
}
