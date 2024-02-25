package laddergame.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import laddergame.domain.strategy.LineBuildStrategy;
import laddergame.domain.strategy.RandomNoTrueSequenceBuildStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사다리")
public class LadderTest {
    @Test
    @DisplayName("생성에 성공한다.")
    public void createLadderTest() {
        //given
        final Height height = new Height("4");
        final List<String> playersName = List.of("name1", "name2");
        final Players players = Players.from(playersName);

        //when
        Ladder ladder = Ladder.buildOf(new RandomNoTrueSequenceBuildStrategy(), players, height);

        //then
        assertEquals(ladder.getLines().size(), height.getHeight());
        assertEquals(ladder.getLines().get(0).getZones().size(), playersName.size() - 1);
    }

    @Test
    @DisplayName("사다리 다리 건설 생성에 성공하는지 테스트한다.")
    public void buildLadderBridge() {
        //given
        final Height height = new Height("1");
        final List<String> playersName = List.of("name1", "name2", "name3", "name4");
        final Players players = Players.from(playersName);
        final List<Zone> expected = List.of(Zone.BRIDGE, Zone.EMPTY, Zone.BRIDGE);

        LineBuildStrategy lineBuildStrategy = new LineBuildStrategy() {
            @Override
            public List<Zone> apply(int count) {
                return expected;
            }
        };

        //when
        Ladder ladder = Ladder.buildOf(lineBuildStrategy, players, height);

        //then
        assertEquals(expected, ladder.getLines().get(0).getZones());
    }
}
