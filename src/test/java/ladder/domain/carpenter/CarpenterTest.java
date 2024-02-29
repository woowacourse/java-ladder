package ladder.domain.carpenter;

import java.util.List;
import ladder.domain.dto.MadeLineDto;
import ladder.domain.ladder.Height;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarpenterTest {

    private static final int personCount = 7;
    private static final int firstLadderIndex = 0;
    private static final int secondLadderIndex = 1;

    private Height height;
    private Energy notEnergetic;
    private Energy energetic;

    @BeforeEach
    void setUp() {
        height = new Height("4");
        notEnergetic = new Energy(() -> 5);
        energetic = new Energy(() -> 6);
    }

    @DisplayName("목수의 체력이 6이상일 경우 사다리를 놓는다.")
    @Test
    void buildLaddersTest() {
        Carpenter carpenter = new Carpenter(height, personCount, energetic);

        carpenter.buildLadders(personCount);

        MadeLineDto madeLine = getLadderOfCarpenter(carpenter);
        Assertions.assertThat(madeLine.line().get(firstLadderIndex).getBuildStatus()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    @DisplayName("목수의 체력이 5이하일 경우 사다리를 놓지 않는다.")
    void notBuildLaddersTest(int stepPosition) {
        Carpenter carpenter = new Carpenter(height, personCount, notEnergetic);

        carpenter.buildLadders(personCount);

        MadeLineDto madeLine = getLadderOfCarpenter(carpenter);
        Assertions.assertThat(madeLine.line().get(stepPosition).getBuildStatus()).isFalse();
    }

    private MadeLineDto getLadderOfCarpenter(Carpenter carpenter) {
        List<MadeLineDto> ladders = carpenter.getResultLadders().madeLine();
        return ladders.get(secondLadderIndex);
    }
}
