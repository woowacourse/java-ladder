package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {
    @Test
    @DisplayName("라인이 비어있으면 예외 발생")
    void validateEmptyLine() {
        assertThatThrownBy(() -> new Line(Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("적어도 가로 라인이 하나이상 있어야 한다.");
    }

    @Test
    @DisplayName("가로 라인이 겹칠 경우, 예외 발생")
    void validateOverlappedRowLine() {
        List<Stick> sticks = List.of(Stick.EXISTENCE, Stick.EXISTENCE, Stick.NON_EXISTENCE);

        assertThatThrownBy(() -> new Line(sticks))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("가로 라인이 이어지면 안된다.");
    }

    @Test
    @DisplayName("해당 위치에 가로 라인이 존재하는 지 테스트")
    void isExistTest() {
        Line line = new Line(List.of(Stick.EXISTENCE, Stick.NON_EXISTENCE, Stick.EXISTENCE));

        assertAll(
                () -> assertThat(line.isExist(0)).isTrue(),
                () -> assertThat(line.isExist(1)).isFalse()
        );
    }

    @Test
    @DisplayName("라인의 사이즈를 구할 수 있는지 테스트")
    void sizeTest() {
        Line line = new Line(List.of(Stick.EXISTENCE, Stick.NON_EXISTENCE, Stick.EXISTENCE));

        assertThat(line.getWidth()).isEqualTo(3);
    }

    @Test
    @DisplayName("라인 양 끝에 공백추가 테스트")
    void addGapTest() {
        Line line = new Line(List.of(Stick.EXISTENCE, Stick.NON_EXISTENCE, Stick.EXISTENCE));
        Line lineAddGap = line.addGap();
        List<Stick> sticks = lineAddGap.getSticks();

        assertAll(
                () -> assertThat(sticks.get(0).isExist()).isFalse(),
                () -> assertThat(sticks.get(sticks.size() - 1).isExist()).isFalse(),
                () -> assertThat(sticks.size()).isEqualTo(5)
        );
    }

    @Test
    @DisplayName("stick이 존재하면 이동후 한칸 내려간다")
    void moveTest() {
        Line line = new Line(List.of(Stick.EXISTENCE, Stick.NON_EXISTENCE, Stick.EXISTENCE));
        Line lineAddGap = line.addGap();

        assertAll(
                () -> assertThat(lineAddGap.move(0)).isEqualTo(1),
                () -> assertThat(lineAddGap.move(2)).isEqualTo(3)
        );
    }
}
