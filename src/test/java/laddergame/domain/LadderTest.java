package laddergame.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import laddergame.domain.strategy.CanBuildStrategy;
import laddergame.util.BooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사다리")
public class LadderTest {
    @Test
    @DisplayName("생성에 성공한다.")
    public void createLadderTest() {
        //given
        final int height = 4;
        final int playerCount = 4;

        //when
        Ladder ladder = new Ladder(playerCount, height);

        //then
        assertEquals(ladder.getLines().size(), height);
        assertEquals(ladder.getLines().get(0).getPoints().size(), playerCount - 1);
    }

    @Test
    @DisplayName("사다리 다리 건설 생성에 성공하는지 테스트한다.")
    public void buildLadderBridge() {
        //given
        final int height = 1;
        final int playerCount = 4;
        List<List<Boolean>> buildResult = new ArrayList<>();
        CanBuildStrategy canBuildStrategy = new CanBuildStrategy() {
            @Override
            public List<Boolean> canBuildBridges(int count) {
                return List.of(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE);
            }
        };

        List<Boolean> booleanList = canBuildStrategy.canBuildBridges(playerCount);
        buildResult.add(booleanList);

        //when
        Ladder ladder = new Ladder(playerCount, height);
        ladder.build(buildResult);

        //then
        assertEquals(ladder.getLines().get(0).getPoints(), booleanList);
    }
}
