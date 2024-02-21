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
        Assertions.assertThatThrownBy(() -> new Line(Collections.EMPTY_LIST))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("적어도 가로 라인이 하나이상 있어야 한다.");
    }

    @Test
    @DisplayName("가로 라인이 겹칠 경우, 예외 발생")
    void validateOverlappedRowLine() {
        List<Stick> rowLines = List.of(Stick.EXISTENCE, Stick.EXISTENCE, Stick.NON_EXISTENCE);

        Assertions.assertThatThrownBy(() -> new Line(rowLines))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("가로 라인이 이어지면 안된다.");
    }

    @Test
    @DisplayName("해당 위치에 가로 라인이 존재하는 지 테스트")
    void isExistTest() {
        Line line = new Line(List.of(Stick.EXISTENCE, Stick.NON_EXISTENCE, Stick.EXISTENCE));

        Assertions.assertThat(line.isExist(1)).isTrue();
        Assertions.assertThat(line.isExist(2)).isFalse();
        Assertions.assertThat(line.isExist(3)).isTrue();
    }


}
