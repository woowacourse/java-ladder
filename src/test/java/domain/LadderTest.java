package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.CustomGenerator;

import java.util.List;

public class LadderTest {

    @DisplayName("높이가 1 이상 50 이하가 아니면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 51})
    void heightRangeTest(int input) {
        Assertions.assertThatThrownBy(() -> new Ladder(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 1 이상 50 이하여야 합니다.");
    }

    @DisplayName("Generator로 만들어진 List로 Line을 생성한다.")
    @Test
    void ladderInitTest() {
        Ladder ladder = new Ladder(5);
        ladder.init(5, new CustomGenerator(List.of(false, true, false, true, false)));
        Assertions.assertThat(ladder.getLine(1))
                .isEqualTo(new Line(List.of(4, 5, 4, 5, 4)));
    }
}
