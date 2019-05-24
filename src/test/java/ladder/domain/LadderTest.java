package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ladder.domain.PointTest.*;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
	private int countOfNumber = 5;
	private int ladderHeight = 3;

	@BeforeEach
	void init() {
		List<Point> points = new ArrayList<>(Arrays.asList(CAN_MOVE_RIGHT_POINT, CAN_MOVE_LEFT_POINT,
				CAN_MOVE_RIGHT_POINT, CAN_MOVE_LEFT_POINT, STOP_POINT));
		List<Line> lines = new ArrayList<>();
		for (int i = 0; i < ladderHeight; ++i) {
			lines.add(new Line(points));
		}

		Ladder.createLadder(countOfNumber, ladderHeight);
	}

	@Test
	void 참가자의_수가_2미만인_경우_예외_반환() {
		assertThrows(IllegalArgumentException.class, () -> Ladder.createLadder(1, 2));
	}

	@Test
	void 참가자의_수가_2이상인_경우() {
		assertDoesNotThrow(() -> Ladder.createLadder(2, 2));
	}

	@Test
	void 사다리의_높이가_2미만인_경우_예외_반환() {
		assertThrows(IllegalArgumentException.class, () -> Ladder.createLadder(2, 1));
	}

	@Test
	void 사다리의_높이가_2이상인_경우() {
		assertDoesNotThrow(() -> Ladder.createLadder(2, 2));
	}
}