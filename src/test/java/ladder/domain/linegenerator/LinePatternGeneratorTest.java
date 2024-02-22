package ladder.domain.linegenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.function.BooleanSupplier;
import ladder.domain.Stick;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LinePatternGeneratorTest {

    @DisplayName("크기에 맞는 사다리 생성")
    @Test
    void generateTest() {
        MockBooleanSupplier supplier = new MockBooleanSupplier(List.of(false, true));
        LinePatternGenerator linePatternGenerator = new LinePatternGenerator(supplier);

        List<Stick> line = linePatternGenerator.generate(4);

        assertThat(line).hasSize(3);
    }

    @DisplayName("숫자가 1이 나왓을 경우, 해당 위치는 막대가 존재하고 다음 위치에는 막대가 없다")
    @Test
    void generateTest_whenReturnOne() {
        BooleanSupplier supplier = () -> true;
        LinePatternGenerator linePatternGenerator = new LinePatternGenerator(supplier);

        List<Stick> line = linePatternGenerator.generate(3);

        assertThat(line).containsExactly(Stick.EXISTENCE, Stick.NON_EXISTENCE);
    }

    @DisplayName("숫자가 0이 나왓을 경우, 해당 위치에 막대가 존재하지 않는다")
    @Test
    void generateTest_whenReturnZero() {
        BooleanSupplier supplier = () -> false;
        LinePatternGenerator linePatternGenerator = new LinePatternGenerator(supplier);

        List<Stick> line = linePatternGenerator.generate(2);

        assertThat(line).containsExactly(Stick.NON_EXISTENCE);
    }

    @DisplayName("사다리 크기가 2보다 작을 경우, 예외를 발생한다")
    @ParameterizedTest
    @CsvSource({"1", "0", "-1"})
    void generateTest_whenSizeIsUnder2(int size) {
        BooleanSupplier supplier = () -> false;
        LinePatternGenerator linePatternGenerator = new LinePatternGenerator(supplier);

        assertThatThrownBy(() -> linePatternGenerator.generate(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 크기는 2 이상입니다");
    }

    class MockBooleanSupplier implements BooleanSupplier {

        private final List<Boolean> mock;
        private int index = 0;

        MockBooleanSupplier(List<Boolean> mock) {
            this.mock = mock;
        }


        @Override
        public boolean getAsBoolean() {
            boolean answer = mock.get(index);
            index = (index + 1) % mock.size();
            return answer;
        }
    }
}