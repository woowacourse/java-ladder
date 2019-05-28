package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameInformationTest {
	@Test
	void validateNumberOfPlayersAndRewards() {
		List<Player> players = new ArrayList<>(Arrays.asList(new Player("pobi"), new Player("jason")));
		List<Reward> rewards = new ArrayList<>(Arrays.asList(new Reward("꽝")));

		assertThrows(IllegalArgumentException.class, () -> new LadderGameInformation(players, rewards));
	}
}