package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.CustomGenerator;

import java.util.List;

import static util.Connection.CONNECTED;
import static util.Connection.UNCONNECTED;

public class LadderGameTest {

    @DisplayName("입력받은 이름과 사다리 높이에 따른 결과를 String으로 반환한다.")
    @Test
    void getLadderShapeTest() {
        List<String> names = List.of("1", "2");
        CustomGenerator customGenerator = new CustomGenerator(List.of(false, true));
        Winnings winnings = new Winnings(List.of("꽝", "당첨"));
        LadderGame ladderGame = new LadderGame(names, new Height(1), winnings, customGenerator);
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
        List<String> names = List.of("1", "2");
        CustomGenerator customGenerator = new CustomGenerator(List.of(false, true));
        Winnings winnings = new Winnings(List.of("꽝", "당첨"));
        LadderGame ladderGame = new LadderGame(names, new Height(1), winnings, customGenerator);
        Assertions.assertThat(ladderGame.getClimbedNames())
                .isEqualTo(List.of("2", "1"));
    }
}
