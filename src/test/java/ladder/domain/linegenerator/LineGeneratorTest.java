package ladder.domain.linegenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.function.BooleanSupplier;
import ladder.domain.Line;
import ladder.domain.Stick;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LineGeneratorTest {

    private static final int PERSON_SIZE = 4;
    private static final int WIDTH_SIZE = 3;
    private static final boolean STICK_NON_EXIST = false;
    private static final boolean STICK_EXIST = true;

    @DisplayName("크기에 맞는 사다리 생성")
    @Test
    void generateTest() {
        MockBooleanSupplier supplier = new MockBooleanSupplier(List.of(STICK_NON_EXIST, STICK_EXIST));
        LineGenerator lineGenerator = new LineGenerator(supplier);

        Line line = lineGenerator.generate(PERSON_SIZE);

        assertThat(line.getWidth()).isEqualTo(WIDTH_SIZE);
    }

    @DisplayName("true 가 나왔을 경우, 해당 위치는 막대가 존재하고 다음 위치에는 막대가 없다")
    @Test
    void generateTest_whenReturnOne() {
        BooleanSupplier supplier = () -> true;
        LineGenerator lineGenerator = new LineGenerator(supplier);

        Line line = lineGenerator.generate(3);

        assertThat(line.getSticks()).containsExactly(Stick.EXISTENCE, Stick.NON_EXISTENCE);
    }

    @DisplayName("false 가 나왔을 경우, 해당 위치에 막대가 존재하지 않는다")
    @Test
    void generateTest_whenReturnZero() {
        BooleanSupplier supplier = () -> false;
        LineGenerator lineGenerator = new LineGenerator(supplier);

        Line line = lineGenerator.generate(2);

        assertThat(line.getSticks()).containsExactly(Stick.NON_EXISTENCE);
    }

    @DisplayName("사다리 크기가 2보다 작을 경우, 예외를 발생한다")
    @ParameterizedTest
    @CsvSource({"1", "0", "-1"})
    void generateTest_whenSizeIsUnder2(int size) {
        BooleanSupplier supplier = () -> false;
        LineGenerator lineGenerator = new LineGenerator(supplier);

        assertThatThrownBy(() -> lineGenerator.generate(size))
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
