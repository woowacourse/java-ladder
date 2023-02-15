package domain.util;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinePointsGeneratorTest {

	class PresentPointGenerator implements PointGenerator {
		@Override
		public Point generate() {
			return Point.PRESENCE;
		}
	}

	@Test
	@DisplayName("연속하지 않도록 교차하는 포인트들의 리스트를 반환해야한다.")
	void lineAlternativePointsGeneratingSuccessTest() {
		int width = 5;
		LinePointsGenerator alternativePointsGenerator = new LinePointsGenerator(width, new PresentPointGenerator());

		List<Point> linePoints = alternativePointsGenerator.generateLine();
		Assertions.assertThat(linePoints).containsExactly(Point.PRESENCE, Point.ABSENCE, Point.PRESENCE, Point.ABSENCE, Point.PRESENCE);
	}
}
