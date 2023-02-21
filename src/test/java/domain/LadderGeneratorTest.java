package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderGeneratorTest {

    @DisplayName("사다리 높이가 참가자 수 미만이면 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource({"3,4", "4,5"})
    void throwExceptionWhenHeightIsLessThanPersonCount(int height, int personCount) {
        LadderGenerator ladderGenerator = new LadderGenerator(new RandomBooleanGenerator());
        assertThatThrownBy(() -> ladderGenerator.generateLadder(height, personCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 참가자 수 이상이어야 합니다.");
    }

    @DisplayName("사다리 높이가 참가자 수 이상이면 예외를 발생시키지 않는다.")
    @ParameterizedTest
    @CsvSource({"4,3", "5,5"})
    void doesNotThrowExceptionWhenHeightIsNotLessThanPersonCount(int height, int personCount) {
        LadderGenerator ladderGenerator = new LadderGenerator(new RandomBooleanGenerator());
        assertThatCode(() -> ladderGenerator.generateLadder(height, personCount))
                .doesNotThrowAnyException();
    }
}
