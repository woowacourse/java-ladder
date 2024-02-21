package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarpenterTest {

    private Height height;

    @BeforeEach
    void setUp() {
        height = new Height("4");
    }

    @DisplayName("목수의 체력이 6이상일 경우 사다리를 놓는다.")
    @Test
    void buildLaddersTest() {
        Carpenter carpenter = new Carpenter(height, 7, () -> 6);

        carpenter.buildLadders(7);

        List<Step> steps = getLadderOfCarpenter(carpenter);
        assertThat(steps.get(0).getBuildStatus()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    @DisplayName("목수의 체력이 5이하일 경우 사다리를 놓지 않는다.")
    void notBuildLaddersTest(int stepPosition) {
        Carpenter carpenter = new Carpenter(height, 7, () -> 5);

        carpenter.buildLadders(7);

        List<Step> steps = getLadderOfCarpenter(carpenter);
        assertThat(steps.get(stepPosition).getBuildStatus()).isFalse();
    }

    private List<Step> getLadderOfCarpenter(Carpenter carpenter) {
        List<Ladder> ladders = carpenter.getResultLadders().resultLadder();
        Ladder ladder = ladders.get(1);
        return ladder.getSteps().steps();
    }
}
