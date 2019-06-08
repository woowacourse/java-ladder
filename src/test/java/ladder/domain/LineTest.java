package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ladder.domain.Point.*;
import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
	private Line line;

	@BeforeEach
	void init() {
		List<Point> points = new ArrayList<>(Arrays.asList(RIGHT_POSITION, LEFT_POSITION, STOP_POSITION));
		line = new Line(points);
	}

	@Test
	void 이동할_수_없을_때_같은_포지션_반환() {
		assertThat(line.getNextPosition(2)).isEqualTo(2);
	}

	@Test
	void 왼쪽으로_이동할_수_있을_때_포지션_반환() {
		assertThat(line.getNextPosition(1)).isEqualTo(0);
	}

	@Test
	void 오른쪽으로_이동할_수_있을_때_포지션_반환() {
		assertThat(line.getNextPosition(0)).isEqualTo(1);
	}
}
