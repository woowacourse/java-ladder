package domain.ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.util.PointGenerator;

class LadderTest {
	// TODO: Ladder 클래스 생성자 수정에 따른 테스트 수정 필요.
	@Test
	@DisplayName("사다리 생성 테스트")
	void buildLadderTest() {
		LadderHeight height = new LadderHeight(3);
		LadderWidth width = new LadderWidth(3);
		Ladder ladder = new Ladder(height, width, new PresentPointGenerator());
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
		return lines.stream()
			.map(Line::getPoints)
			.collect(Collectors.toList());
	}

	@Test
	@DisplayName("0, 1, 2, 3의 index가 1, 0, 3, 2로 변해야 한다.")
	void getMovedIndexTest() {
		Ladder ladder = new Ladder(new LadderHeight(3), new LadderWidth(3), new PresentPointGenerator());
		// TODO: getMovedIndex() 메서드 사용 불가.
		List<Integer> indices = ladder.getMovedIndex();
		Assertions.assertThat(indices).containsExactly(1, 0, 3, 2);
	}

	static class PresentPointGenerator implements PointGenerator {
		@Override
		public Point generate() {
			return Point.PRESENCE;
		}
	}
}
