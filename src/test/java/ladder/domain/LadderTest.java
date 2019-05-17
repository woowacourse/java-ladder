package ladder.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
	private Ladder ladder;
	private int countOfNumber = 5;

	@BeforeEach
	void init() {
		List<Boolean> points = new ArrayList<>();
		for (int i = 0; i < countOfNumber; ++i) {
			points.add((i % 2 == 0) ? true : false);
		}

		List<Line> lines = new ArrayList<>();
		for (int i = 0; i < 3; ++i) {
			lines.add(new Line(points));
		}

		ladder = new Ladder(lines);
	}

	@Test
	void 참가자의_처음_위치에_따라_마지막_위치_반환() {
		int[] playerLastPosition = {1, 0, 3, 2, 5};

		for (int i = 0; i < countOfNumber; ++i) {
			assertEquals(ladder.getLastPosition(i), playerLastPosition[i]);
		}
	}

}