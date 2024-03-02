import static org.assertj.core.api.Assertions.assertThat;

import domain.Point;
import domain.ladder.Row;
import domain.player.PlayerCount;
import domain.player.Players;
import java.util.List;
import mock.RightPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RowTest {
    public static final Point RIGHT_MOVE_POINT = new Point(false, true);
    public static final Point LEFT_MOVE_POINT = new Point(true, false);

    @Test
    @DisplayName("기둥에 발판이 있으면 연결된 다음 기둥에는 발판이 없어야하고, 마지막 다리는 발판이 없다.")
    void makeLineExist() {
        // given
        final Row row = Row.create2(PlayerCount.fromPlayers(Players.from(List.of("a", "b", "c"))), new RightPointGenerator());

        // when & then
        assertThat(row.getPoints()).containsExactly(RIGHT_MOVE_POINT, LEFT_MOVE_POINT, RIGHT_MOVE_POINT,
                LEFT_MOVE_POINT);
    }

    @Test
    @DisplayName("모든 기둥에 발판이 없는 경우를 확인한다.")
    void makeLineEmpty() {
        // given
        final Row row = Row.create2(PlayerCount.fromPlayers(Players.from(List.of("a", "b", "c"))), new RightPointGenerator());

        // when & then
        assertThat(row.getPoints()).containsExactly(RIGHT_MOVE_POINT, LEFT_MOVE_POINT, RIGHT_MOVE_POINT,
                LEFT_MOVE_POINT);
    }

    // |-----|     |-----|
    @Test
    void playRow() {
        final Row row = Row.create2(PlayerCount.fromPlayers(Players.from(List.of("a", "b", "c"))), new RightPointGenerator());
        int index = row.playRow2(0);
        assertThat(index).isEqualTo(1);
    }

    @Test
    void create() {
        Row row = Row.create2(PlayerCount.fromPlayers(Players.from(List.of("a", "b", "c"))), new RightPointGenerator());
        assertThat(row.getPoints()).containsExactly(RIGHT_MOVE_POINT, LEFT_MOVE_POINT,
                RIGHT_MOVE_POINT, LEFT_MOVE_POINT);
    }
}
