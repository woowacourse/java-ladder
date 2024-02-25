package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import ladder.domain.linegenerator.LineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

    @DisplayName("사다리의 높이를 알 수 있다")
    @Test
    void getHeightTest() {
        LineGenerator lineGenerator = size -> List.of(Stick.EXISTENCE, Stick.NON_EXISTENCE);
        Ladder ladder = new Ladder(new Height(3), 2, lineGenerator);

        int actual = ladder.getHeight();

        assertThat(actual).isEqualTo(3);
    }

    @DisplayName("사다리의 길이를 구할 수 있다")
    @Test
    void getWidthTest() {
        LineGenerator lineGenerator = size -> List.of(Stick.EXISTENCE, Stick.NON_EXISTENCE);
        Ladder ladder = new Ladder(new Height(3), 2, lineGenerator);

        int actual = ladder.getWidth();

        assertThat(actual).isEqualTo(2);
    }

    @DisplayName("특정 좌표에 스틱이 존재하는지 알 수 있다")
    @Test
    void isExistTest() {
        LineGenerator lineGenerator = size -> List.of(Stick.EXISTENCE, Stick.NON_EXISTENCE);
        Ladder ladder = new Ladder(new Height(3), 2, lineGenerator);

        boolean actual = ladder.isExist(2, 1);

        assertThat(actual).isFalse();
    }

    @DisplayName("요청하는 높이가 0보다 작거나 총 높이보다 큰 경우, 예외를 발생시킨다")
    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    void isExistTest_whenHeightIsOutOfRange(int heightValue) {
        Height height = new Height(3);
        LineGenerator lineGenerator = size -> List.of(Stick.EXISTENCE, Stick.NON_EXISTENCE);
        Ladder ladder = new Ladder(height, 2, lineGenerator);
        int widthValue = 0;

        assertThatThrownBy(() -> ladder.isExist(heightValue, widthValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("높이 위치가 범위를 벗어났습니다.");
    }
}
