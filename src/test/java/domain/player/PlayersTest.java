package domain.player;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.player.Player;
import domain.player.Players;

class PlayersTest {

	@Test
	@DisplayName("이름으로부터 플레이어를 찾아낸다.")
	void findPlayerFromNameTest() {
		// given
		Player player = new Player("A", 0);
		Players players = new Players(List.of(player));

		// when
		Player actual = players.findPlayerFromName("A");

		// then
		assertThat(actual).isEqualTo(player);
	}

	@Test
	@DisplayName("플레이어 이름이 존재하지 않으면, 예외가 발생된다.")
	void findPlayerFromName_WithNotExistName() {
		Player player = new Player("A", 0);
		Players players = new Players(List.of(player));

		assertThatThrownBy(() -> players.findPlayerFromName("B"))
			.isInstanceOf(IllegalArgumentException.class);
	}
}