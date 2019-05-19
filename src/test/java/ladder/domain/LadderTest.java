package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
	private Ladder ladder;
	private int countOfNumber = 5;

	@BeforeEach
	void init() {
		List<Point> points = new ArrayList<>(Arrays.asList(new Point(false, true),
				new Point(true, false), new Point(false, true),
				new Point(true, false),
				new Point(false, false)));

		List<Line> lines = new ArrayList<>();
		for (int i = 0; i < 3; ++i) {
			lines.add(new Line(points));
		}

		ladder = new Ladder(lines);
	}

	@Test
	void 참가자의_처음_위치에_따라_마지막_위치_반환() {
		int[] playerLastPosition = {1, 0, 3, 2, 4};

		for (int i = 0; i < countOfNumber; ++i) {
			assertEquals(ladder.getLastPosition(i), playerLastPosition[i]);
		}
	}

	@Test
	void 참가자의_수가_2미만인_경우_예외_반환() {
		assertThrows(IllegalArgumentException.class, () -> Ladder.generateLadder(1, "2"));
	}

	@Test
	void 참가자의_수가_2이상인_경우() {
		assertDoesNotThrow(() -> Ladder.generateLadder(2, "2"));
	}

	@Test
	void 사다리의_높이가_2미만인_경우_예외_반환() {
		assertThrows(IllegalArgumentException.class, () -> Ladder.generateLadder(2, "1"));
	}

	@Test
	void 사다리의_높이가_2이상인_경우() {
		assertDoesNotThrow(() -> Ladder.generateLadder(2, "2"));
	}
}