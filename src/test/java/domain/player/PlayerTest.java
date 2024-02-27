package domain.player;

import static org.assertj.core.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.ladder.Ladder;
import generator.LadderFloorGenerator;

class PlayerTest {

	@Test
	@DisplayName("모든 막대가 연결된 3층 사다리를 타고 내려온다.")
	void playWithAllConnectedLadder() {
		// given
		Ladder ladder = createAllConnectedLadder();
		Player playerA = new Player("A", 0);
		Player playerB = new Player("B", 1);

		// when
		playerA.playLadder(ladder);
		playerB.playLadder(ladder);
		int expectedPlayerAPosition = 1;
		int expectedPlayerBPosition = 0;

		// then
		assertThat(expectedPlayerAPosition).isEqualTo(playerA.getPosition());
		assertThat(expectedPlayerBPosition).isEqualTo(playerB.getPosition());
	}

	@Test
	@DisplayName("모든 막대가 연결되지 않은 3층 사다리를 타고 내려온다.")
	void playWithNotConnectedLadder() {
		// given
		Ladder ladder = createNotConnectedLadder();
		Player playerA = new Player("A", 0);
		Player playerB = new Player("B", 1);

		// when
		playerA.playLadder(ladder);
		playerB.playLadder(ladder);
		int expectedPlayerAPosition = 0;
		int expectedPlayerBPosition = 1;

		// then
		assertThat(expectedPlayerAPosition).isEqualTo(playerA.getPosition());
		assertThat(expectedPlayerBPosition).isEqualTo(playerB.getPosition());
	}

	/**
	 * @return 두 막대가 모두 연결된 3층 사다리
	 */
	private Ladder createAllConnectedLadder() {
		return createTestLadder(true);
	}

	/**
	 * @return 두 막대가 모두 연결되지 않은 3층 사다리
	 */
	private Ladder createNotConnectedLadder() {
		return createTestLadder(false);
	}

	private Ladder createTestLadder(boolean value) {
		Ladder ladder = Ladder.of(2, 3);
		Random random = new Random() {
			@Override
			public boolean nextBoolean() {
				return value;
			}
		};
		LadderFloorGenerator generator = new LadderFloorGenerator(random);
		ladder.drawLines(generator);

		return ladder;
	}
}