package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.util.Point;
import domain.util.PointGenerator;

class LadderBuilderTest {

	class PresentPointGenerator implements PointGenerator {
		@Override
		public Point generate() {
			return Point.PRESENCE;
		}
	}

	@Test
	@DisplayName("사다리 생성 테스트")
	void buildLadderTest() {
		LadderHeight height = new LadderHeight(3);
		LadderWidth width = new LadderWidth(3);
		LadderBuilder builder = new LadderBuilder();
		Ladder ladder = builder.build(height, width, new PresentPointGenerator());
		assertThat(ladder.getLadderPoints()).containsExactly(
				List.of(
						Point.PRESENCE, Point.ABSENCE, Point.PRESENCE),
				List.of(
						Point.PRESENCE, Point.ABSENCE, Point.PRESENCE),
				List.of(
						Point.PRESENCE, Point.ABSENCE, Point.PRESENCE));
	}
}
