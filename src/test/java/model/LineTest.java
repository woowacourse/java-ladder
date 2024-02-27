package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import model.line.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("참여할 사람은 최소 2명이다.")
    void createLineThrowException() {
        assertThatThrownBy(() -> new Line(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 경로는 비어있더라도 최소 1개 이상이여야 합니다.");
    }

    @Test
    @DisplayName("사다리의 경로는 연달아 있을 수 없다.")
    void createPathThrowException() {
        List<Path> paths = List.of(Path.EXIST, Path.EXIST, Path.NOT_EXIST);
        assertThatThrownBy(() -> new Line(paths))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 경로는 연달아 있을 수 없습니다.");
    }
}
