package ladder.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {
	@Test
	void 참가자_중복_이름_검사() {
		Player player = new Player("pobi");
		assertThrows(IllegalArgumentException.class, () -> new Players(Arrays.asList(player, player)));
	}

	@Test
	void 참가자의_수가_2미만일_때() {
		List<Player> players = Arrays.asList(new Player("pobi"));
		assertThrows(IllegalArgumentException.class, () -> new Players(players));
	}

	@Test
	void 참가자의_수가_2이상일_때() {
		List<Player> players = Arrays.asList(new Player("pobi"), new Player("jason"));
		assertDoesNotThrow(() -> new Players(players));
	}

	@Test
	void 참가자_리스트_인덱스_검사() {
		Players players = new Players(Arrays.asList(new Player("jason"), new Player("pobi")));
		assertThrows(IllegalArgumentException.class, () -> players.getPlayer(-1));
		assertThrows(IllegalArgumentException.class, () -> players.getPlayer(2));
		assertDoesNotThrow(() -> players.getPlayer(1));
	}
}