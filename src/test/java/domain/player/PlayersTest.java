package domain.player;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayersTest {

	@ParameterizedTest
	@ValueSource(ints = {1, 11})
	@DisplayName("플레이어 수 범위를 초과시 예외가 발생된다.")
	void lessPlayerCountExceptionTest(int playerCount) {
		List<Player> players = generatePlayerList(playerCount);

		assertThatThrownBy(() -> new Players(players)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("이름으로부터 플레이어를 찾아낸다.")
	void findPlayerFromNameTest() {
		// given
		Player playerA = new Player("A", 0);
		Player playerB = new Player("B", 1);
		Players players = new Players(List.of(playerA, playerB));

		// when
		Player actual = players.findPlayerFromName("A");

		// then
		assertThat(actual).isEqualTo(playerA);
	}

	@Test
	@DisplayName("플레이어 이름이 존재하지 않으면, 예외가 발생된다.")
	void findPlayerFromName_WithNotExistName() {
		Player playerA = new Player("A", 0);
		Player playerB = new Player("B", 1);
		Players players = new Players(List.of(playerA, playerB));

		assertThatThrownBy(() -> players.findPlayerFromName("C"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	private List<Player> generatePlayerList(int count) {
		return Stream.generate(() -> new Player("name", 0))
			.limit(count)
			.toList();
	}
}
