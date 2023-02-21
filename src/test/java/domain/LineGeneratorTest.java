package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LineGeneratorTest {

    @ParameterizedTest
    @DisplayName("사람 수를 입력받으면 사람 수보다 하나 적은 라인이 생성된다")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void randomLineLengthTest(int personCount) {
        final LineGenerator lineGenerator = new LineGenerator(new RandomLinkGenerator());
        final Line line = lineGenerator.generate(personCount);
        final int lineNumber = line.getLinks().size();
        final int expectedLineNumber = personCount - 1;
        Assertions.assertThat(lineNumber).isEqualTo(expectedLineNumber);
    }
}
