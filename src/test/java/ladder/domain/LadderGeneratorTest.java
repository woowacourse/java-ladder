package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGeneratorTest {
	@Test
	void 참가자의_수가_2미만인_경우_예외_반환() {
		assertThrows(IllegalArgumentException.class, () ->  LadderGenerator.generateLadder(1 ,"2"));
	}

	@Test
	void 참가자의_수가_2이상인_경우() {
		assertDoesNotThrow(() ->  LadderGenerator.generateLadder(2,"2"));
	}

	@Test
	void 사다리의_높이가_2미만인_경우_예외_반환() {
		assertThrows(IllegalArgumentException.class, () ->  LadderGenerator.generateLadder(2,"1"));
	}

	@Test
	void 사다리의_높이가_2이상인_경우() {
		assertDoesNotThrow(() ->  LadderGenerator.generateLadder(2,"2"));
	}
}