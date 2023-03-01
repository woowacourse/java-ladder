//package ladder.domain.ladder;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
//
//class PointTest {
//    //포인트는 아래로 내려갈 수 있다.
//
//
//    @Test
//    @DisplayName("1인 위치가 아래로 내려가면 위치가 1이다")
//    void moveDownTest() {
//        Point point = new Point(false);
//        Position position = point.moveDirection(new Position(1));
//
//        assertThat(position).isEqualTo(new Position(1));
//    }
//
//    @Test
//    @DisplayName("1인 위치가 오른쪽으로 이동하면면 위치가 2이다")
//    void moveRightTest() {
//        Point point = new Point(false).next(true);
//
//        Position position = point.moveDirection(new Position(1));
//
//        assertThat(position).isEqualTo(new Position(2));
//    }
//
//    @Test
//    @DisplayName("1인 위치가 왼쪽으로 이동하면면 위치가 0이다")
//    void moveLeftTest() {
//        Point point = new Point(true).next(false);
//        Position position = point.moveDirection(new Position(1));
//
//        assertThat(position).isEqualTo(new Position(0));
//    }
//
//    @Test
//    @DisplayName("양쪽이 연결되어 있으면 에러가 발생한다")
//    void moveFailTest() {
//        assertThatThrownBy(() -> new Point(true).next(true));
//    }
//
//    @Test
//    @DisplayName("시작 위치가 0이면 왼쪽으로 내려갈 수 없다")
//    void moveFailWhenPositionIsZeroTest() {
//        Point point = new Point(true).next(false);
//
//        assertThatThrownBy(() -> point.moveDirection(new Position(0)));
//    }
//
//    @Test
//    @DisplayName("시작 위치가 0이면 오른쪽으로 갈 수 있다")
//    void moveright() {
//        Point point = new Point(true);
//        assertDoesNotThrow(() -> point.moveDirection(new Position(0)));
//    }
//
//    @Test
//    @DisplayName("마지막 포인트는 오른쪽으로 생성할 수 없다")
//    void last() {
//        // |-----
//        Point point = new Point(true);
//        // -----|
//        final Point nextPoint = point.last();
//
//        assertThat(nextPoint).isEqualTo(new Point(true).next(false));
//    }
//}
//
