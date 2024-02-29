package domain.ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.player.Player;

class FloorTest {

	Floor floor;

	@BeforeEach
	void setUP() {
		floor = new Floor(List.of(Bar.CONNECTED_TO_RIGHT, Bar.CONNECTED_TO_LEFT, Bar.NOT_CONNECTED));
	}

	@Test
	@DisplayName("오른쪽으로 연결된 막대인 경우, 플레이어를 오른쪽으로 이동한다.")
	void movePlayerToRightTest() {
		// given
		Player player = new Player("A", 0);

		// when
		floor.movePlayer(player);

		// then
		assertThat(player.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("왼쪽으로 연결된 막대인 경우, 플레이어를 왼쪽으로 이동한다.")
	void movePlayerToLeftTest() {
		// given
		Player player = new Player("A", 1);

		// when
		floor.movePlayer(player);

		// then
		assertThat(player.getPosition()).isEqualTo(0);
	}

	@Test
	@DisplayName("연결되지 않은 막대인 경우, 플레이어를 이동시키지 않는다.")
	void dontMovePlayerTest() {
		// given
		Player player = new Player("A", 2);

		// when
		floor.movePlayer(player);

		// then
		assertThat(player.getPosition()).isEqualTo(2);
	}
}
