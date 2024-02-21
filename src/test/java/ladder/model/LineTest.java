package ladder.model;

import ladder.utils.BooleanGenerator;
import ladder.utils.FixedBooleanGenerator;
import ladder.utils.RandomBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    @DisplayName("지정된 수 만큼의 길이를 갖는 한 행이 생성된다.")
    void createLineByLengthTest() {
        BooleanGenerator bg = new FixedBooleanGenerator(true);

        Line line = Line.of(5, bg);

        int actual = line.size();
        int expected = 5;

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "true, true",
            "false, false"
    })
    @DisplayName("왼쪽에 경로가 존재하는지를 확인한다.")
    void leftPathExistTest(boolean value, boolean expected) {
        BooleanGenerator bg = new FixedBooleanGenerator(value);

        Line line = Line.of(5, bg);
        boolean actual = Line.isLeftPathExist(line.getRow(), 1);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "true, false",
            "false, false"
    })
    @DisplayName("첫번째 칸의 왼쪽은 경로가 없다.")
    void leftPathOfFirstIndexNotExist(boolean value, boolean expected) {
        BooleanGenerator bg = new FixedBooleanGenerator(value);

        Line line = Line.of(5, bg);
        boolean actual = Line.isLeftPathExist(line.getRow(), 0);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("동일한 가로줄에는 연속된 경로가 없다.")
    void continuousPathNotExistInSameLine() {
        Line line = Line.of(5, new FixedBooleanGenerator(true));

        List<Boolean> actual = line.getRow();
        List<Boolean> expected = List.of(true, false, true, false, true);

        assertThat(actual).isEqualTo(expected);
    }
}
