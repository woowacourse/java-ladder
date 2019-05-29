package ladder.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {
	@Test
	void overlapPlayerNames() {
		Player player = new Player("pobi");
		assertThrows(IllegalArgumentException.class, () -> new Players(Arrays.asList(player, player)));
	}

	@Test
	void validateNumberOfPlayersIsLessThanTwo() {
		List<Player> players = Arrays.asList(new Player("pobi"));
		assertThrows(IllegalArgumentException.class, () -> new Players(players));
	}

	@Test
	void validateNumberOfPlayers() {
		List<Player> players = Arrays.asList(new Player("pobi"), new Player("jason"));
		assertDoesNotThrow(() -> new Players(players));
	}

	@Test
	void invalidIndex() {
		Players players = new Players(Arrays.asList(new Player("jason"), new Player("pobi")));
		assertThrows(IllegalArgumentException.class, () -> players.getPlayer(-1));
		assertThrows(IllegalArgumentException.class, () -> players.getPlayer(2));
		assertDoesNotThrow(() -> players.getPlayer(1));
	}
}