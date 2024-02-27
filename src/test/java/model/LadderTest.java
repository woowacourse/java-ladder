package model;

import static model.path.Path.EXIST;
import static model.path.Path.NOT_EXIST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import model.path.FixedPathGenerator;
import model.path.RandomPathGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

    @Test
    @DisplayName("사다리를 생성한다.")
    void createLadder() {
        Line line = new Line(List.of(EXIST, NOT_EXIST));
        List<Line> expectedLines = List.of(line);
        FixedPathGenerator pathGenerator = new FixedPathGenerator(expectedLines);
        int height = 1;
        int personCount = 2;

        Ladder ladder = Ladder.from(height, personCount, pathGenerator);
        assertThat(ladder.getLines()).isEqualTo(expectedLines);
    }

    @ParameterizedTest(name = "사다리의 높이는 1 이상이다.")
    @ValueSource(ints = {1, 5})
    void createLadder(int height) {
        assertThatCode(() -> Ladder.from(height, 4, new RandomPathGenerator()));
    }

    @Test
    @DisplayName("사다리의 높이는 1 미만은 불가능이다.")
    void createLadderThrowException() {
        int height = 0;
        assertThatThrownBy(() -> Ladder.from(height, 4, new RandomPathGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 1 이상이어야 합니다.");
    }

    @Test
    @DisplayName("사다리의 개인별 결과를 확인한다.")
    void climbLadderPersonResult() {
        int height = 5;
        int personCount = 4;
        FixedPathGenerator pathGenerator = new FixedPathGenerator(
                List.of(new Line(List.of(EXIST, NOT_EXIST, EXIST)),
                        new Line(List.of(NOT_EXIST, EXIST, NOT_EXIST)),
                        new Line(List.of(EXIST, NOT_EXIST, NOT_EXIST)),
                        new Line(List.of(NOT_EXIST, EXIST, NOT_EXIST)),
                        new Line(List.of(EXIST, NOT_EXIST, EXIST)))
        );
        Ladder ladder = Ladder.from(height, personCount, pathGenerator);
        assertThat(ladder.climb(1)).isEqualTo(1);
    }
}
