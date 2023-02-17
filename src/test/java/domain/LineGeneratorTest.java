package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LineGeneratorTest {
    private final LineGenerator lineGenerator = new LineGenerator();

    @ParameterizedTest
    @DisplayName("랜덤으로 생성된 Line의 길이가 맞는지 테스트")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void randomLineLengthTest(int personCount) {
        Line line = lineGenerator.generate(personCount);
        int lineNumber = line.getLine().size();
        int expectedLineNumber = personCount - 1;
        Assertions.assertThat(lineNumber).isEqualTo(expectedLineNumber);
    }

    @RepeatedTest(100)
    @DisplayName("랜덤으로 생성된 Line이 유효한지 반복 테스트")
    void randomLineValidateTest() {
        int validatePersonCount = 4;
        assertDoesNotThrow(() -> lineGenerator.generate(validatePersonCount));
    }
}
