package domain.game;

import domain.ladder.Bridge;
import domain.ladder.Ladder;
import domain.strategy.TestBridgeMakingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static domain.ladder.Bridge.EMPTY;
import static domain.ladder.Bridge.EXIST;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class LadderGameTest {

    @Test
    @DisplayName("사다리 타기 게임 결과가 정상적으로 반환되는가")
    void ladder_game_result_returns_correctly() {
        List<Bridge> bridges = List.of(
                EXIST, EMPTY,
                EXIST, EMPTY,
                EMPTY, EXIST,
                EXIST, EMPTY
        );
        TestBridgeMakingStrategy strategy = new TestBridgeMakingStrategy(bridges);

        Ladder ladder = new Ladder(2, 4, strategy);

        PathMapper pathMapper = LadderGame.play(ladder);

        List<Integer> departure = List.of(0, 1, 2);
        List<Integer> arrival = List.of(1, 2, 0);

        assertSoftly(softly -> {
            softly.assertThat(pathMapper.findArrival(0)).isEqualTo(arrival.get(0));
            softly.assertThat(pathMapper.findArrival(1)).isEqualTo(arrival.get(1));
            softly.assertThat(pathMapper.findArrival(2)).isEqualTo(arrival.get(2));
        });

    }

}
