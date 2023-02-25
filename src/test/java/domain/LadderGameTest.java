package domain;

import domain.numbergenerator.TestNumberGenerator;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @DisplayName("사다리가 주어졌을 때 연결구조에 맞게 사다리 게임 참가자의 위치가 변경된다.")
    @Test
    void runTest() {
        // given
        String kong = "kong";
        String odo = "odo";
        String gray = "gray";
        String kiara = "kiara";

        String prize1 = "꽝";
        String prize2 = "1000";
        String prize3 = "2000";
        String prize4 = "1000";

        Ladder ladder = new Ladder(4, 4, new TestNumberGenerator(Lists.newArrayList(1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0)));
        Players players = new Players(List.of(kong, odo, gray, kiara));
        Prizes prizes = new Prizes(List.of(prize1, prize2, prize3, prize4), 4);

        Map<Player, Prize> expected = new HashMap<>();
        expected.put(new Player(kong, 0), new Prize(prize4));
        expected.put(new Player(odo, 0), new Prize(prize2));
        expected.put(new Player(gray, 0), new Prize(prize1));
        expected.put(new Player(kiara, 0), new Prize(prize3));

        // when
        LadderGame ladderGame = new LadderGame(ladder, players, prizes);
        Map<Player, Prize> result = ladderGame.run();

        // then
        assertThat(result).isEqualTo(expected);
    }
}
