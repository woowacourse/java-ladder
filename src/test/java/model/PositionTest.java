package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import model.path.Path;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositionTest {

    @DisplayName("위치는 depth와 column을 갖는다.")
    @Test
    void createPoint() {
        int depth = 0;
        int column = 0;
        Position position = new Position(depth, column);
        assertThat(position.depth()).isEqualTo(depth);
        assertThat(position.column()).isEqualTo(column);
    }

    @Test
    @DisplayName("현재 위치보다 한칸 왼쪽의 위치를 반환한다.")
    void getLeftPosition() {
        Position position = new Position(1, 1);
        Position leftPosition = position.getLeftPosition();
        assertThat(leftPosition.depth()).isEqualTo(1);
        assertThat(leftPosition.column()).isEqualTo(0);
    }

    @Test
    @DisplayName("현재 위치보다 한칸 오른쪽의 위치를 반환한다.")
    void getRightPosition() {
        Position position = new Position(1, 1);
        Position rightPosition = position.getRightPosition();
        assertThat(rightPosition.depth()).isEqualTo(1);
        assertThat(rightPosition.column()).isEqualTo(2);
    }

    @Test
    @DisplayName("현재 위치보다 한칸 아래의 위치를 반환한다.")
    void getBelowPosition() {
        Position position = new Position(1, 1);
        Position belowPosition = position.getBelowPosition();
        assertThat(belowPosition.depth()).isEqualTo(2);
        assertThat(belowPosition.column()).isEqualTo(1);
    }

    @Test
    @DisplayName("라인위에 위치가 있는지 검사한다.")
    public void checkWithinLine() {
        Line line = new Line(List.of(Path.EXIST, Path.NOT_EXIST, Path.NOT_EXIST));
        Position position1 = new Position(0, 0);
        Position position2 = new Position(0, 3);
        assertThatCode(
                () -> {
                    position1.checkWithinLine(line);
                    position2.checkWithinLine(line);
                }
        ).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("라인보다 왼쪽에 있는 좌표는 올바르지 않다.")
    public void checkWithinLineThrowsExceptionWhenColumnUnderZero() {
        Line line = new Line(List.of(Path.EXIST, Path.NOT_EXIST, Path.NOT_EXIST));
        Position position = new Position(0, -1);
        assertThatThrownBy(() -> position.checkWithinLine(line))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("올바르지 않은 위치입니다.");
    }

    @Test
    @DisplayName("라인보다 오른쪽에 있는 좌표는 올바르지 않다.")
    public void checkWithinLineThrowsExceptionWhenColumnOrMoreMaxColumn() {
        Line line = new Line(List.of(Path.EXIST, Path.NOT_EXIST, Path.NOT_EXIST));
        Position position = new Position(0, 5);
        assertThatThrownBy(() -> position.checkWithinLine(line))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("올바르지 않은 위치입니다.");
    }

    @Test
    @DisplayName("가장 왼쪽 위치인지 여부를 반환한다.")
    public void isFarLeft() {
        Position position = new Position(0, 0);
        boolean isFarLeft = position.isFarLeft();
        assertThat(isFarLeft).isTrue();
    }

    @Test
    @DisplayName("가장 오른쪽 위치인지 여부를 반환한다.")
    public void isFarRight() {
        Line line = new Line(List.of(Path.EXIST, Path.NOT_EXIST, Path.NOT_EXIST));
        Position position = new Position(0, 3);
        boolean isFarRight = position.isFarRight(line);
        assertThat(isFarRight).isTrue();
    }

    @Test
    @DisplayName("해당 위치의 왼쪽 인덱스를 반환한다.")
    public void getLeftPathIndex() {
        Position position = new Position(0, 1);
        int leftPathIndex = position.getLeftPathIndex();
        assertThat(leftPathIndex).isEqualTo(0);
    }

    @Test
    @DisplayName("왼쪽 인덱스는 없다 0 이하의 ")
    public void getLeftPathIndexThrowsExceptionWhenColumnOrLessZero() {
        Position position = new Position(0, 0);
        assertThatThrownBy(() -> position.getLeftPathIndex())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(0 + " 왼쪽의 경로는 없습니다.");
    }

    @Test
    @DisplayName("해당 위치의 오른쪽 인덱스를 반환한다.")
    public void getRightPathIndex() {
        Line line = new Line(List.of(Path.EXIST, Path.NOT_EXIST, Path.NOT_EXIST));
        Position position = new Position(0, 2);
        int rightPathIndex = position.getRightPathIndex(line);
        assertThat(rightPathIndex).isEqualTo(2);
    }

    @Test
    @DisplayName("해당 위치의 오른쪽 인덱스를 반환한다.")
    public void getRightPathIndexThrowsExceptionWhenColumnOrMoreMaxColumn() {
        Line line = new Line(List.of(Path.EXIST, Path.NOT_EXIST, Path.NOT_EXIST));
        Position position = new Position(0, 4);
        assertThatThrownBy(() -> position.getRightPathIndex(line))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(4 + " 오른쪽의 경로는 없습니다.");
    }
}