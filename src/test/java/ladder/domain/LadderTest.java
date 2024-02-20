package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {

    @Test
    void hasDuplicatedStep() {
        Ladder ladder = new Ladder(5);
        ladder.buildSteps(0);

        Boolean hasDuplicateStep = ladder.hasStepDuplicated(1);

        assertThat(hasDuplicateStep).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4})
    void changeLadderStepStatus(int currentSector) {
        Ladder ladder = new Ladder(5);

        ladder.buildSteps(currentSector);

        assertThat(ladder.getSteps().get(currentSector)).isTrue();
    }
}
