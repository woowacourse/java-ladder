package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import model.path.Path;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LineTest {

    @Test
    @DisplayName("참여할 사람은 최소 2명이다.")
    void createLineThrowException() {
        assertThatThrownBy(() -> new Line(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여할 사람은 최소 2명이어야 합니다.");
    }

    @Test
    @DisplayName("사다리의 경로는 연달아 있을 수 없다.")
    void createPathThrowException() {
        List<Path> paths = List.of(Path.EXIST, Path.EXIST, Path.NOT_EXIST);
        assertThatThrownBy(() -> new Line(paths))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 경로는 연달아 있을 수 없습니다.");
    }

    @ParameterizedTest(name = "왼쪽으로 길이 있는지 확인한다.")
    @CsvSource({"0, false", "1, true", "2, false", "3, false", "4, true"})
    void hasLeftPath(int column, boolean expected) {
        List<Path> paths = List.of(Path.EXIST, Path.NOT_EXIST, Path.NOT_EXIST, Path.EXIST);
        Line line = new Line(paths);
        boolean hasLeftPath = line.hasLeftPath(column);
        assertThat(hasLeftPath).isEqualTo(expected);
    }

    @ParameterizedTest(name = "오른쪽으로 길이 있는지 확인한다.")
    @CsvSource({"0, true", "1, false", "2, false", "3, true", "4, false"})
    void hasRightPath(int column, boolean expected) {
        List<Path> paths = List.of(Path.EXIST, Path.NOT_EXIST, Path.NOT_EXIST, Path.EXIST);
        Line line = new Line(paths);
        boolean hasRightPath = line.hasRightPath(column);
        assertThat(hasRightPath).isEqualTo(expected);
    }
}