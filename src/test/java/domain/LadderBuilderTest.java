package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

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
		List<List<Point>> points2D = changeToPoints2D(ladder);

		assertThat(points2D).containsExactly(
			List.of(
				Point.PRESENCE, Point.ABSENCE, Point.PRESENCE
			),
			List.of(
				Point.PRESENCE, Point.ABSENCE, Point.PRESENCE
			),
			List.of(
				Point.PRESENCE, Point.ABSENCE, Point.PRESENCE
			));
	}

	private List<List<Point>> changeToPoints2D(Ladder ladder) {
		List<Line> lines = ladder.getLines();
		List<List<Point>> points2D = lines.stream()
			.map(line -> line.getPoints())
			.collect(Collectors.toList());
		return points2D;
	}
}
