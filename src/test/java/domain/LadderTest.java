package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.BooleanGenerator;
import utils.RandomBooleanGenerator;

public class LadderTest {
    private static final BooleanGenerator booleanGenerator = new RandomBooleanGenerator();
    private static final int PERSON_NUMBER = 4;

    @DisplayName("사다리 높이는 1 이상 100 이하이다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 99, 100})
    void validHeightTest(int height) {
        Assertions.assertDoesNotThrow(() -> new Ladder(PERSON_NUMBER, height, booleanGenerator));
    }

    @DisplayName("사다리 높이가 1 미만 100 초과인 경우 예외 처리한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 101, 102})
    void invalidHeightTest(int height) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(PERSON_NUMBER, height, booleanGenerator))
                .withMessageContaining("[ERROR] 1 이상 100 이하의 자연수만 입력해 주세요.");
    }
}
