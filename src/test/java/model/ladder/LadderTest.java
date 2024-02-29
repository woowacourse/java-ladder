package model.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import model.bridge.Bridge;
import model.player.Player;
import model.player.Players;
import model.prize.Prize;
import model.prize.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @DisplayName("사다리는 사다리 높이만큼의 라인을 가진다")
    @Test
    void testSizeOfLadderLines() {
        Players players = Players.from(List.of("pobi", "lala"));
        LadderHeight ladderHeight = new LadderHeight(5);
        Ladder ladder = Ladder.of(ladderHeight, players, (count) -> createBridges(List.of(1, 0)));
        assertThat(ladder.getLines().size())
                .isEqualTo(5);
    }

    private static List<Bridge> createBridges(List<Integer> codes) {
        return codes.stream()
                .map(code -> Bridge.findBridgeByCode(code).orElse(null))
                .toList();
    }

    @DisplayName("참여자들에 대한 사다리 실행 결과를 얻는다")
    @Test
    void testLadderPlayOutcomeIncludesAllParticipants() {
        Players players = Players.from(List.of("pobi", "lala"));
        LadderHeight ladderHeight = new LadderHeight(5);
        Ladder ladder = Ladder.of(ladderHeight, players, (count) -> createBridges(List.of(1)));
        Prizes prizes = Prizes.of(players,
                List.of(new Prize("꽝"), new Prize("3000")));

        LadderPlayOutcome ladderPlayOutcome = ladder.play(players, prizes);
        Map<Player, Prize> outcome = ladderPlayOutcome.getOutcome();

        assertThat(outcome.get(new Player("pobi")).getContent())
                .isEqualTo("3000");
        assertThat(outcome.get(new Player("lala")).getContent())
                .isEqualTo("꽝");
    }
}
