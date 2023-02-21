package domain;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.ladder.Ladder;
import domain.ladder.LadderBuilder;
import domain.ladder.LadderHeight;
import domain.ladder.LadderWidth;
import domain.util.Point;
import domain.util.PointGenerator;

class IndexMoverTest {

	static class PresentPointGenerator implements PointGenerator {
		@Override
		public Point generate() {
			return Point.PRESENCE;
		}
	}

	@Test
	@DisplayName("0, 1, 2의 index가 1, 0, 2로 변해야 한다.")
	void indexMoverTest() {
		int height = 3;
		int width = 3;
		PointGenerator generator = new PresentPointGenerator();
		Ladder ladder = makeLadder(height, width, generator);

		IndexMover indexMover = new IndexMover();
		List<Integer> indices = indexMover.getMovedIndex(ladder);

		Assertions.assertThat(indices).containsExactly(1, 0, 3, 2);
	}

	private static Ladder makeLadder(final int height, final int width, final PointGenerator generator) {
		LadderHeight ladderHeight = new LadderHeight(height);
		LadderWidth ladderWidth = new LadderWidth(width);
		LadderBuilder builder = new LadderBuilder();
		return builder.build(ladderHeight, ladderWidth, generator);
	}
}
/*
0 1 2 3
|o|x|o|
|o|x|o|
|o|x|o|
 */
