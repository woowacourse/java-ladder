package game;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.LadderHeight;
import domain.Player;
import domain.Players;
import domain.Prizes;
import generator.LadderFloorGenerator;

class LadderGameTest {

	LadderGame ladderGame;

	/**
	 다음과 같은 형태의 사다리를 이용하여 테스트한다.
	 |-----|
	 |-----|
	 |-----|
	 */
	@BeforeEach
	void setUP() {
		LadderFloorGenerator generator = new LadderFloorGenerator(() -> true);
		ladderGame = new LadderGame(generator);
		ladderGame.createRandomLadder(2, new LadderHeight(3));
	}

	@Test
	@DisplayName("모든 플레이어의 결과를 정확하게 얻는다.")
	void getAllPlayersPrizeNameTest() {
		// given
		Players players = new Players(List.of(
			new Player("A", 0),
			new Player("B", 1)
		));
		Prizes prizes = Prizes.fromNames(List.of("꽝", "당첨"));

		// when
		Map<String, String> actual = ladderGame.getAllPlayersPrizeNames(players, prizes);
		Map<String, String> expected = Map.of("A", "당첨", "B", "꽝");

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	@DisplayName("플레이어 한 명의 결과를 정확하게 얻는다")
	void getOnePlayersPrizeName() {
		// given
		Player player = new Player("A", 0);
		Prizes prizes = Prizes.fromNames(List.of("당첨", "꽝"));

		// when
		String actual = ladderGame.getOnePlayersPrizeName(player, prizes);
		String expected = "꽝";

		// then
		assertThat(actual).isEqualTo(expected);
	}
}