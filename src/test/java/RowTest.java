import static org.assertj.core.api.Assertions.assertThat;

import domain.ladder.Point;
import domain.ladder.Row;
import domain.player.PlayerCount;
import domain.player.Players;
import java.util.List;
import mock.falseSupplier;
import mock.trueSupplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RowTest {
    public static final Point RIGHT_MOVE_POINT = Point.of(false, true);
    public static final Point LEFT_MOVE_POINT = Point.of(true, false);
    public static final Point STAY_POINT = Point.of(false, false);

    /*
    a     b     c     d
    |-----|     |-----|
     */
    @Test
    @DisplayName("기둥에 발판이 있으면 연결된 다음 기둥에는 발판이 없어야하고, 마지막 다리는 발판이 없다.")
    void makeLineExist() {
        // given
        final Row row = Row.create(PlayerCount.fromPlayers(Players.from(List.of("a", "b", "c", "d"))), new trueSupplier());

        // when & then
        assertThat(row.getPoints()).containsExactly(RIGHT_MOVE_POINT, LEFT_MOVE_POINT, RIGHT_MOVE_POINT, LEFT_MOVE_POINT);
    }

    @Test
    @DisplayName("모든 기둥에 발판이 없는 경우를 확인한다.")
    void makeLineEmpty() {
        // given
        final Row row = Row.create(PlayerCount.fromPlayers(Players.from(List.of("a", "b", "c", "d"))),
                new falseSupplier());

        // when & then
        assertThat(row.getPoints()).containsExactly(STAY_POINT, STAY_POINT, STAY_POINT,
                STAY_POINT);
    }

    /*
    a     b     c     d
    |-----|     |-----|
     */
    @Test
    @DisplayName("오른쪽에 발판이 있으면 가로 위치가 1 증가한다.")
    void playRowRight() {
        final Row row = Row.create(PlayerCount.fromPlayers(Players.from(List.of("a", "b", "c", "d"))),
                new trueSupplier());
        int index = row.playRow(0);
        assertThat(index).isEqualTo(1);
    }

    @Test
    @DisplayName("왼쪽에 발판이 있으면 가로 위치가 1 감소한다.")
    void playRowLeft() {
        final Row row = Row.create(PlayerCount.fromPlayers(Players.from(List.of("a", "b", "c", "d"))),
                new trueSupplier());
        int index = row.playRow(1);
        assertThat(index).isEqualTo(0);
    }
}
