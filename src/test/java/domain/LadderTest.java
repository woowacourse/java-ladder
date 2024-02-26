package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import generator.LadderFloorGenerator;

class LadderTest {

	@Test
	@DisplayName("모든 막대가 연결된 사다리를 타고 내려온다.")
	void playWithAllConnectedLadder() {
		// given
		Ladder ladder = createAllConnectedLadder();
		Player playerA = new Player("A", 0);
		Player playerB = new Player("B", 1);

		// when
		ladder.play(playerA);
		ladder.play(playerB);

		// then
		assertThat(playerA.getPosition()).isEqualTo(1);
		assertThat(playerB.getPosition()).isEqualTo(0);
	}

	@Test
	@DisplayName("모든 막대가 연결되지 않은 사다리를 타고 내려온다.")
	void playWithNotConnectedLadder() {
		// given
		Ladder ladder = createNotConnectedLadder();
		Player playerA = new Player("A", 0);
		Player playerB = new Player("B", 1);

		// when
		ladder.play(playerA);
		ladder.play(playerB);

		// then
		assertThat(playerA.getPosition()).isEqualTo(0);
		assertThat(playerB.getPosition()).isEqualTo(1);
	}

	/**
	 * @return 두 막대가 모두 연결된 3층 사다리
	 */
	private Ladder createAllConnectedLadder() {
		return createLadder(() -> true);
	}

	/**
	 * @return 두 막대가 모두 연결되지 않은 3층 사다리
	 */
	private Ladder createNotConnectedLadder() {
		return createLadder(() -> false);
	}

	private Ladder createLadder(BooleanSupplier supplier) {
		Ladder ladder = Ladder.of(2, 3);
		LadderFloorGenerator generator = new LadderFloorGenerator(supplier);
		ladder.drawLines(generator);

		return ladder;
	}
}