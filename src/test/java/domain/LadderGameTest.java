package domain;

import domain.numbergenerator.TestNumberGenerator;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @DisplayName("사다리가 주어졌을 때 연결구조에 맞게 사다리 게임 참가자의 위치가 변경된다.")
    @Test
    void runTest() {
        String kong = "kong";
        String odo = "odo";
        String gray = "gray";
        String kiara = "kiara";

        Ladder ladder = new Ladder(4, 4, new TestNumberGenerator(Lists.newArrayList(1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0)));
        Players players = new Players(List.of(kong, odo, gray, kiara));
        LadderGame ladderGame = new LadderGame(ladder, players);
        Map<String, Integer> result = ladderGame.run();
        assertThat(result.get(kong)).isEqualTo(3);
        assertThat(result.get(odo)).isEqualTo(1);
        assertThat(result.get(gray)).isEqualTo(0);
        assertThat(result.get(kiara)).isEqualTo(2);
    }
}
