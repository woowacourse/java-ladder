package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import generator.LadderFloorGenerator;

class PlayerTest {

	@Test
	@DisplayName("두 막대가 연결되어 있을 때 오른쪽으로 이동한다.")
	void moveToRightTest() {
		HorizontalLine horizontalLine = createHorizontalLine(() -> true);

		Player player = new Player("A", 0);
		player.move(horizontalLine);

		assertThat(player.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("두 막대가 연결되어 있을 때 왼쪽으로 이동한다.")
	void moveToLeftTest() {
		HorizontalLine horizontalLine = createHorizontalLine(() -> true);

		Player player = new Player("A", 1);
		player.move(horizontalLine);

		assertThat(player.getPosition()).isEqualTo(0);
	}

	@Test
	@DisplayName("두 막대가 연결되어 있지 않으면 이동하지 않는다.")
	void moveNotTest() {
		// given
		HorizontalLine horizontalLine = createHorizontalLine(() -> false);
		Player playerA = new Player("A", 0);
		Player playerB = new Player("B", 1);

		// when
		playerA.move(horizontalLine);
		playerB.move(horizontalLine);

		// then
		assertThat(playerA.getPosition()).isEqualTo(0);
		assertThat(playerB.getPosition()).isEqualTo(1);
	}

	private HorizontalLine createHorizontalLine(BooleanSupplier supplier) {
		LadderFloorGenerator generator = new LadderFloorGenerator(supplier);
		HorizontalLine horizontalLine = new HorizontalLine(2);
		horizontalLine.createCrossingLines(generator);

		return horizontalLine;
	}
}