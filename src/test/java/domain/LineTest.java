package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LineTest {

    @DisplayName("양옆에 다리가 없으면 위치를 그대로 반환한다.")
    @ParameterizedTest
    @CsvSource({"0,0", "3,3"})
    void shouldReturnOriginalIndexWhenPointIsDisconnected(int index, int expected) {
        LineGenerator lineGenerator = new LineGenerator(new TestBooleanGenerator(Lists.newArrayList(false, true)));
        Line line = lineGenerator.generateLine(4);
        assertThat(line.move(index)).isEqualTo(expected);
    }

    @DisplayName("양옆에 다리가 있으면 이동한 위치를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1,2", "2,1"})
    void shouldReturnMovedIndexWhenPointIsConnected(int index, int expected) {
        LineGenerator lineGenerator = new LineGenerator(new TestBooleanGenerator(Lists.newArrayList(false, true)));
        Line line = lineGenerator.generateLine(4);
        assertThat(line.move(index)).isEqualTo(expected);
    }
}
