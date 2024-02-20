package ladder.domain.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class RandomLadderStepGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    @DisplayName("올바르게 랜덤한 사다리 스텝을 생성한다.")
    void createRandomLadderStepTest(int participantCount) {
        // given
        LadderStepGenerator randomLadderStepGenerator = new RandomLadderStepGenerator();

        // when & then
        assertThatCode(() -> randomLadderStepGenerator.generate(participantCount))
                .doesNotThrowAnyException();
    }
}
