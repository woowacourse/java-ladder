package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.booleanGenerator.BooleanGenerator;
import utils.booleanGenerator.RandomBooleanGenerator;

class LinesTest {

    private BooleanGenerator booleanGenerator = new RandomBooleanGenerator();

    @DisplayName("1이상 100이하 층 수를 테스트한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 99, 100})
    void validFloorCountTest(int floorCount) {
        assertDoesNotThrow(() -> new Lines(4, floorCount, booleanGenerator));
    }

    @DisplayName("1미만 100초과 층 수를 예외처리한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 101, 102})
    void invalidFloorCountTest(int floorCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lines(4, floorCount, booleanGenerator));
    }
}
