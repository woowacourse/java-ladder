package domain.ladder;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

	@Test
	@DisplayName("0, 1, 2, 3, 4가 1, 0, 3, 2, 4로 변해야 한다.")
	void moveOnceTest() {
		int width = 4;
		Line line = new Line(width, new PresentPointGenerator());
		List<Integer> initialIdx = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			initialIdx.add(i);
		}

		List<Integer> moved = line.moveThroughLine(initialIdx);
		List<Integer> expected = List.of(1, 0, 3, 2, 4);
		Assertions.assertThat(moved).containsExactlyElementsOf(expected);
	}

	static class PresentPointGenerator implements PointGenerator {
		@Override
		public Point generate() {
			return Point.PRESENCE;
		}
	}
}
