import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import domain.ladder.Point;
import domain.ladder.Row;
import domain.player.PlayerCount;
import domain.player.Players;
import java.util.List;
import mock.falseSupplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    @DisplayName("양쪽 다 다리가 있는 경우에는 예외를 발생한다.")
    void invalidPoint() {
        assertThatIllegalArgumentException().isThrownBy(() -> Point.of(true, true));
    }

    @Test
    @DisplayName("오른쪽에만 다리가 있는 경우에는 가로 위치가 1 증가한다.")
    void moveRight() {
        Point point = Point.of(false, true);
        int resultIndex = point.applyMove(0);
        assertThat(resultIndex).isEqualTo(1);
    }

    @Test
    @DisplayName("왼쪽에만 다리가 있는 경우에는 가로 위치가 1 감소한다.")
    void moveLeft() {
        Point point = Point.of(true, false);
        int resultIndex = point.applyMove(1);
        assertThat(resultIndex).isEqualTo(0);
    }

    @Test
    @DisplayName("첫번째 지점에는 왼쪽 발판이 있을 수 없다.")
    void createFisrt() {
        final Row row = Row.create(PlayerCount.fromPlayers(Players.from(List.of("a", "b", "c", "d"))),
                new falseSupplier());
        Point point = row.getPoints().get(0);
        assertThat(point.isLeft()).isFalse();
    }
    @Test
    @DisplayName("마지막 지점에는 오른쪽 발판이 있을 수 없다.")
    void createLast() {
        final Row row = Row.create(PlayerCount.fromPlayers(Players.from(List.of("a", "b", "c", "d"))),
                new falseSupplier());
        Point point = row.getPoints().get(0);
        assertThat(point.isRight()).isFalse();
    }
}
