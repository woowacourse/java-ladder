package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

    @DisplayName("사다리의 높이만큼 라인을 생성한다")
    @ParameterizedTest(name = "{index} : 사다리 높이 {0}만큼 라인을 생성한다 ")
    @ValueSource(ints = {3, 4, 5, 6})
    void ladder_height_test(int height) {
        Ladder ladder = Ladder.make(4, height, new RandomLadderGenerator());
        assertThat(ladder.getHeight()).isEqualTo(height);
    }

    @DisplayName("사다리의 높이가 1 이상 10 이하가 아니면 예외가 발생한다.")
    @ParameterizedTest(name = "{index} : 현재 사다리 높이 = {0}")
    @ValueSource(ints = {-1, 0, 11})
    void ladder_invalid_test(int height) {
        assertThatThrownBy(() -> Ladder.make(4, height, new RandomLadderGenerator()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Ladder.VALID_HEIGHT_FORMANT, Ladder.MIN_RANGE, Ladder.MAX_RANGE);
    }

    @DisplayName("사다리의 높이가 1 이상 10 이하이면 사다리를 생성한다.")
    @ParameterizedTest(name = "{index} : 현재 사다리 높이 = {0}")
    @ValueSource(ints = {1, 5, 10})
    void ladder_valid_test(int height) {
        assertDoesNotThrow(() -> Ladder.make(4, height, new RandomLadderGenerator()));
    }


    @DisplayName("사람 {수 -1} 길이의 사다리의 폭을 생성한다")
    @ParameterizedTest(name = "{index} : 사다리의 폭의 길이는 {0}-1 이다 ")
    @ValueSource(ints = {3, 4, 5, 6})
    void ladder_width_test(int personCount) {
        Ladder ladder = Ladder.make(personCount, 3, new RandomLadderGenerator());
        assertThat(ladder.getWidth()).isEqualTo(personCount - 1);

    }

    @DisplayName("사람의 위치를 넣으면 어디로 갈지 정해주는 기능 테스트")
    @ParameterizedTest(name = "{index} : ({0}, {1})은 {2} 로 가야한다.")
    @CsvSource({
        "0, 0, RIGHT", "1, 0, LEFT", "2, 0, RIGHT", "3, 0, LEFT",
        "0, 1, NO", "1, 1, RIGHT", "2, 1, LEFT", "3, 1, NO"})
    void findShiftType(int widthIndex, int heightIndex, ShiftType expected) {
        //given
        LadderGenerator testRadderGenerator = (width, height) -> List.of(
            new Line(List.of(true, false, true)),
            new Line(List.of(false, true, false)),
            new Line(List.of(true, false, false)),
            new Line(List.of(false, true, false)),
            new Line(List.of(true, false, true)));

        Ladder ladder = Ladder.make(4, 5, testRadderGenerator);
        //when
        ShiftType actual = ladder.findShiftType(widthIndex, heightIndex);
        //then
        assertThat(actual).isEqualTo(expected);
    }
}
