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
    void getResultTest() {
        List<String> names = List.of("1", "2", "3", "4", "5");
        CustomGenerator customGenerator = new CustomGenerator(List.of(false, true, false, true, false));
        LadderGame ladderGame = new LadderGame(names, new Height(5), customGenerator);
        Assertions.assertThat(ladderGame.getResult())
                .isEqualTo(List.of(
                        "     1     2     3     4     5",
                        UNCONNECTED.getBridge() + CONNECTED.getBridge() + UNCONNECTED.getBridge() + CONNECTED.getBridge() + UNCONNECTED.getBridge(),
                        UNCONNECTED.getBridge() + CONNECTED.getBridge() + UNCONNECTED.getBridge() + CONNECTED.getBridge() + UNCONNECTED.getBridge(),
                        UNCONNECTED.getBridge() + CONNECTED.getBridge() + UNCONNECTED.getBridge() + CONNECTED.getBridge() + UNCONNECTED.getBridge(),
                        UNCONNECTED.getBridge() + CONNECTED.getBridge() + UNCONNECTED.getBridge() + CONNECTED.getBridge() + UNCONNECTED.getBridge(),
                        UNCONNECTED.getBridge() + CONNECTED.getBridge() + UNCONNECTED.getBridge() + CONNECTED.getBridge() + UNCONNECTED.getBridge()
                ));
    }
}
