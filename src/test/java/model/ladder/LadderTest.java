package model.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import model.bridge.Bridge;
import model.ladder.dto.LadderPlayOutcome;
import model.player.Players;
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

    @DisplayName("모든 참여자에 대한 사다리 실행 결과를 얻는다")
    @Test
    void testLadderPlayOutcomeIncludesAllParticipants() {
        List<String> beforePlayerNames = List.of("pobi", "lala");
        Players players = Players.from(beforePlayerNames);
        LadderHeight ladderHeight = new LadderHeight(5);
        Ladder ladder = Ladder.of(ladderHeight, players, (count) -> createBridges(List.of(1, 0)));
        List<LadderPlayOutcome> ladderPlayOutcomes = ladder.play();

        List<String> afterPlayerNames = ladderPlayOutcomes.stream()
                .map(LadderPlayOutcome::getName)
                .toList();

        assertThat(afterPlayerNames)
                .containsAll(beforePlayerNames);
    }
}
