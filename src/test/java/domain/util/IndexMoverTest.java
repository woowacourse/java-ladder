package domain.util;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.ladder.Ladder;
import domain.ladder.LadderBuilder;
import domain.ladder.LadderHeight;
import domain.ladder.LadderWidth;

class IndexMoverTest {

	private static Ladder makeLadder(final int height, final int width, final PointGenerator generator) {
		LadderHeight ladderHeight = new LadderHeight(height);
		LadderWidth ladderWidth = new LadderWidth(width);
		LadderBuilder builder = new LadderBuilder();
		return builder.build(ladderHeight, ladderWidth, generator);
	}

	@Test
	@DisplayName("0, 1, 2, 3의 index가 1, 0, 3, 2로 변해야 한다.")
	void indexMoverTest() {
		int height = 3;
		int width = 3;
		PointGenerator generator = new PresentPointGenerator();
		Ladder ladder = makeLadder(height, width, generator);

		List<Integer> indices = IndexMover.getMovedIndex(ladder);

		Assertions.assertThat(indices).containsExactly(1, 0, 3, 2);
	}

	static class PresentPointGenerator implements PointGenerator {
		@Override
		public Point generate() {
			return Point.PRESENCE;
		}
	}
}
