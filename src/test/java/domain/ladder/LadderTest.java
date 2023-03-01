package domain.ladder;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

	@Test
	@DisplayName("1, 0, 3, 2의 순서로 매칭된 결과가 나와야 한다.")
	void getMappedResultTest() {
		Ladder ladder = Ladder.of(3, 3, new PresentPointGenerator());
		List<Integer> movedIndex = ladder.getMovedIndex(3);
		List<Integer> expected = List.of(1, 0, 3, 2);
		Assertions.assertThat(movedIndex).isEqualTo(expected);
	}

	static class PresentPointGenerator implements PointGenerator {
		@Override
		public Point generate() {
			return Point.PRESENCE;
		}
	}
}
