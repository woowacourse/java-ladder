package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
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