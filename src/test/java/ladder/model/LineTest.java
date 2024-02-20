package ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private final Line line = new Line(List.of(true, false, true, false, true));

    @Test
    @DisplayName("왼쪽에 사다리가 있다면 true를 반환한다.")
    public void leftLadderExistTest() {
        int position = 1;
        boolean actual = line.isLeftLadderExist(position);
        boolean expected = true;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("왼쪽에 사다리가 없다면 false를 반환한다.")
    public void leftLadderNotExistTest() {
        int position = 2;
        boolean actual = line.isLeftLadderExist(position);
        boolean expected = false;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("첫번째 사다리 왼쪽은 사다리가 없는 것으로 간주한다.")
    public void firstLadderTest() {
        int position = 0;
        boolean actual = line.isLeftLadderExist(position);
        boolean expected = false;

        assertThat(actual).isEqualTo(expected);
    }
}
