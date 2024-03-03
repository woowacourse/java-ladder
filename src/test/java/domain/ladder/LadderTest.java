package domain.ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.player.Player;
import domain.player.Players;
import domain.prize.Prize;
import domain.prize.Prizes;
import generator.RandomLadderGenerator;

public class LadderTest {
	Ladder ladder;

	/**
	 다음과 같은 형태의 사다리를 이용하여 테스트한다.
	 A     B     C
	 |-----|     |
	 |     |-----|
	 |-----|     |
	 1등   2등   3등
	 */
	@BeforeEach
	void setUP() {
		Random random = createTestRandom(true, false, true, true);
		RandomLadderGenerator generator = new RandomLadderGenerator(random);
		ladder = generator.generate(3, 3);
	}

	@Test
	@DisplayName("모든 플레이어의 결과를 정확하게 얻는다.")
	void getAllPlayersPrizeNameTest() {
		// given
		Players players = new Players(List.of(
			new Player("A", 0),
			new Player("B", 1),
			new Player("C", 2)
		));
		Prizes prizes = new Prizes(List.of(
			new Prize("1등"),
			new Prize("2등"),
			new Prize("3등")
		));

		// when
		Map<String, String> actual = ladder.getAllPlayerPrizes(players, prizes);
		Map<String, String> expected = Map.of("A", "3등", "B", "2등", "C", "1등");

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	@DisplayName("플레이어 한 명의 결과를 정확하게 얻는다")
	void getOnePlayersPrizeName() {
		// given
		Player player = new Player("A", 0);
		Prizes prizes = new Prizes(List.of(
			new Prize("1등"),
			new Prize("2등"),
			new Prize("3등")
		));

		// when
		String actual = ladder.getOnePlayerPrize(player, prizes);
		String expected = "3등";

		// then
		assertThat(actual).isEqualTo(expected);
	}

	private Random createTestRandom(Boolean... values) {
		Iterator<Boolean> iterator = List.of(values).iterator();

		return new Random() {
			@Override
			public boolean nextBoolean() {
				return iterator.next();
			}
		};
	}
}
