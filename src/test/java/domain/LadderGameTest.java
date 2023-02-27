package domain;

import domain.booleangenerator.TestBooleanGenerator;
import domain.ladder.Ladder;
import domain.player.Player;
import domain.player.Players;
import domain.prize.Prize;
import domain.prize.Prizes;
import domain.prize.Results;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

        Ladder ladder = Ladder.of(4, 4, new TestBooleanGenerator(Lists.newArrayList(true, false, false, false, true, false, true, false, true, false, false, false)));
        Players players = new Players(List.of(kong, odo, gray, kiara));
        Prizes prizes = Prizes.of(List.of(prize1, prize2, prize3, prize4), 4);

        Results expected = new Results();
        expected.addResult(Player.from(kong), new Prize(prize4));
        expected.addResult(Player.from(odo), new Prize(prize2));
        expected.addResult(Player.from(gray), new Prize(prize1));
        expected.addResult(Player.from(kiara), new Prize(prize3));

        // when
        LadderGame ladderGame = new LadderGame(ladder, players, prizes);
        Results result = ladderGame.run();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("사다리 게임을 두 번 이상 하더라도 사다리 게임의 결과값이 변하지 않는다.")
    @Test
    void runTest2() {
        // given
        String kong = "kong";
        String odo = "odo";
        String gray = "gray";
        String kiara = "kiara";

        String prize1 = "꽝";
        String prize2 = "1000";
        String prize3 = "2000";
        String prize4 = "1000";

        Ladder ladder = Ladder.of(4, 4, new TestBooleanGenerator(Lists.newArrayList(true, false, false, false, true, false, true, false, true, false, false, false)));
        Players players = new Players(List.of(kong, odo, gray, kiara));
        Prizes prizes = Prizes.of(List.of(prize1, prize2, prize3, prize4), 4);

        Results expected = new Results();
        expected.addResult(Player.from(kong), new Prize(prize4));
        expected.addResult(Player.from(odo), new Prize(prize2));
        expected.addResult(Player.from(gray), new Prize(prize1));
        expected.addResult(Player.from(kiara), new Prize(prize3));

        // when
        LadderGame ladderGame = new LadderGame(ladder, players, prizes);
        ladderGame.run();
        Results result = ladderGame.run();

        // then
        assertThat(result).isEqualTo(expected);
    }
}
