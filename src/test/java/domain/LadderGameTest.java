package domain;

import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static util.Connection.CONNECTED;
import static util.Connection.UNCONNECTED;

public class LadderGameTest {

    @DisplayName("입력받은 이름과 사다리 높이에 따른 결과를 String으로 반환한다.")
    @Test
    void getResultTest() {
        LadderGame ladderGame = new LadderGame(
                new Players(List.of("1", "2")),
                new Winnings(List.of("1", "2"), 2),
                new Height(1),
                new CustomGenerator(List.of(false, true))
        );
        Assertions.assertThat(ladderGame.getLadderSequence())
                .isEqualTo(List.of(
                        "     1     2",
                        UNCONNECTED.getBridge() + CONNECTED.getBridge(),
                        "     1     2"
                ));
    }

    @DisplayName("라인들을 순회하며 연결된 인덱스의 List<Name>을 swap한 결과를 Map으로 반환한다.")
    @Test
    void swapForConnected() {
        LadderGame ladderGame = new LadderGame(
                new Players(List.of("a", "b")),
                new Winnings(List.of("1", "2"), 2),
                new Height(1),
                new CustomGenerator(List.of(false, true))
        );
        Assertions.assertThat(ladderGame.getResult())
                .isEqualTo(Map.of("a", "2", "b", "1"));
    }
}
