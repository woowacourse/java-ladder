package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGeneratorTest {
	@Test
	void 생성자에_올바른_값이_입력된_경우() {
		assertDoesNotThrow(() -> LadderGenerator.generateLadder(5,6));
	}

	@Test
	void 생성자에_참가자_수가_음수인_경우() {
		assertThrows(IllegalArgumentException.class, () ->  LadderGenerator.generateLadder(-1,6));
	}

	@Test
	void 생성자에_사다리의_높이가_음수인_경우() {
		assertThrows(IllegalArgumentException.class, () ->  LadderGenerator.generateLadder(5,-1));
	}

}