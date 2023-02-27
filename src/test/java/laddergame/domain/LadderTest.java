package laddergame.domain;

import static laddergame.TestDummy.HEIGHT_VALUE_1;
import static laddergame.TestDummy.WIDTH_VALUE_2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사다리")
class LadderTest {

    @DisplayName("너비가 null이면 예외가 발생한다.")
    @Test
    void throwExceptionWhenParticipantIsNull() {
        //given
        final Width width = null;
        final Height height = new Height(1);
        final List<Line> lines = List.of(new Line(List.of(true, false, true)));
        //when
        //then
        assertThatThrownBy(() -> new Ladder(width, height, lines))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("높이가 null이면 예외가 발생한다.")
    @Test
    void throwExceptionWhenHeightIsNull() {
        //given
        final Width width = new Width(2);
        final Height height = null;
        final List<Line> lines = List.of(new Line(List.of(true, false, true)));
        //when,then
        assertThatThrownBy(() -> new Ladder(width, height, lines))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성한다.")
    @Test
    void create() {
        //given
        final Width width = new Width(2);
        final Height height = new Height(2);
        final List<Line> lines = List.of(new Line(List.of(true, false, true)), new Line(List.of(true, false, true)));
        //when,then
        assertDoesNotThrow(() -> new Ladder(width, height, lines));
    }

    @DisplayName("라인 사이즈가 비면 예외가 발생한다.")
    @Test
    void createdLineSizeIsNotEmpty() {
        //given
        final List<Line> lines = List.of(new Line(List.of(true, false, true)));
        final Ladder ladder = new Ladder(WIDTH_VALUE_2, HEIGHT_VALUE_1, lines);

        //when,then
        assertThat(ladder.getLines()).isNotEmpty();
    }

    @DisplayName("생성된 라인의 개수는 높이와 같아야 한다.")
    @Test
    void createLineSizeIsEqualToHeight() {
        //given
        final List<Line> lines = List.of(new Line(List.of(true, false, true)));
        final Ladder ladder = new Ladder(WIDTH_VALUE_2, HEIGHT_VALUE_1, lines);

        //when,then
        assertThat(ladder.getLines()).hasSize(HEIGHT_VALUE_1.getValue());
    }
}
