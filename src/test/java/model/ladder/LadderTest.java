package model.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import model.bridge.Bridge;
import model.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    @DisplayName("사다리는 사다리 높이만큼의 라인을 가짐")
    @Test
    void testSizeOfLadderLines() {
        Players players = Players.create(List.of("pobi", "lala"));
        LadderHeight ladderHeight = new LadderHeight(5);
        Ladder ladder = Ladder.create(ladderHeight, players, (count) -> createBridges(List.of(1, 0)));
        assertThat(ladder.getLines().size())
                .isEqualTo(5);
    }

    private static List<Bridge> createBridges(List<Integer> codes) {
        return codes.stream()
                .map(code -> Bridge.findBridgeByCode(code).orElse(null))
                .toList();
    }
}
