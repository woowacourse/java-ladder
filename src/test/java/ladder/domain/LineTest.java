package ladder.domain;

import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {
    @Test
    @DisplayName("라인이 비어있으면 예외 발생")
    void validateEmptyLine() {
        Assertions.assertThatThrownBy(() -> new Line(Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("적어도 가로 라인이 하나이상 있어야 한다.");
    }

    @Test
    @DisplayName("가로 라인이 겹칠 경우, 예외 발생")
    void validateOverlappedRowLine() {
        List<Stick> sticks = List.of(Stick.EXISTENCE, Stick.EXISTENCE, Stick.NON_EXISTENCE);

        Assertions.assertThatThrownBy(() -> new Line(sticks))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("가로 라인이 이어지면 안된다.");
    }

    @Test
    @DisplayName("해당 위치에 가로 라인이 존재하는 지 테스트")
    void isExistTest() {
        Line line = new Line(List.of(Stick.EXISTENCE, Stick.NON_EXISTENCE, Stick.EXISTENCE));

        Assertions.assertThat(line.isExist(0)).isTrue();
        Assertions.assertThat(line.isExist(1)).isFalse();
    }

    @Test
    @DisplayName("라인의 사이즈를 구할 수 있는지 테스트")
    void sizeTest() {
        Line line = new Line(List.of(Stick.EXISTENCE, Stick.NON_EXISTENCE, Stick.EXISTENCE));

        Assertions.assertThat(line.getWidth()).isEqualTo(3);
    }

    @Test
    @DisplayName("라인 양 끝에 공백추가 테스트")
    void addGapTest() {
        Line line = new Line(List.of(Stick.EXISTENCE, Stick.NON_EXISTENCE, Stick.EXISTENCE));
        Line lineAddGap = line.addGap();
        List<Stick> sticks = lineAddGap.getSticks();

        Assertions.assertThat(sticks.get(0).isExist()).isFalse();
        Assertions.assertThat(sticks.get(sticks.size() - 1).isExist()).isFalse();
        Assertions.assertThat(sticks.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("stick이 존재하면 이동후 한칸 내려간다")
    void moveTest() {
        Line line = new Line(List.of(Stick.EXISTENCE, Stick.NON_EXISTENCE, Stick.EXISTENCE));
        Line lineAddGap = line.addGap();

        Assertions.assertThat(lineAddGap.move(0)).isEqualTo(1);
        Assertions.assertThat(lineAddGap.move(1)).isEqualTo(0);
        Assertions.assertThat(lineAddGap.move(2)).isEqualTo(3);
        Assertions.assertThat(lineAddGap.move(3)).isEqualTo(2);
    }
}
