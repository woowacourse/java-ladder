package domain;

import static util.Connection.CONNECTED;
import static util.Connection.UNCONNECTED;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

    @DisplayName("입력받은 이름과 사다리 높이에 따른 결과를 String으로 반환한다.")
    @Test
    void getLadderShapeTest() {
        Players players = new Players(List.of("1", "2"));
        CustomGenerator customGenerator = new CustomGenerator(List.of(false, true));
        Winnings winnings = new Winnings(List.of("꽝", "당첨"));
        LadderGame ladderGame = new LadderGame(players, new Height(1), winnings, customGenerator);
        Assertions.assertThat(ladderGame.getLadderShape())
                .isEqualTo(List.of(
                        "     1     2",
                        UNCONNECTED.getBridge() + CONNECTED.getBridge(),
                        "     꽝    당첨"
                ));
    }

    @DisplayName("사다리 타기 결과의 순서와 상응하는 이름들을 List로 반환한다.")
    @Test
    void getClimbedNamesTest() {
        Players players = new Players(List.of("1", "2"));
        CustomGenerator customGenerator = new CustomGenerator(List.of(false, true));
        Winnings winnings = new Winnings(List.of("꽝", "당첨"));
        LadderGame ladderGame = new LadderGame(players, new Height(1), winnings, customGenerator);
        Assertions.assertThat(ladderGame.getClimbedNames())
                .isEqualTo(List.of(new Name("2"), new Name("1")));
    }

    @DisplayName("사다리 타기 결과에 맞게 이름과 결과를 Map 으로 반환한다.")
    @Test
    void getResultTest() {
        Players players = new Players(List.of("1", "2"));
        CustomGenerator customGenerator = new CustomGenerator(List.of(false, true));
        Winnings winnings = new Winnings(List.of("꽝", "당첨"));
        LadderGame ladderGame = new LadderGame(players, new Height(1), winnings, customGenerator);
        Assertions.assertThat(ladderGame.getResult())
                .isEqualTo(Map.of(new Name("1"), new Winning("당첨"), new Name("2"), new Winning("꽝")));
    }
}
