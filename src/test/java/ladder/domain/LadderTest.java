package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderTest {

	@Test
	void 사다리_생성자에_올바른_값이_입력된_경우() {
		assertDoesNotThrow(() -> new Ladder(5,6));
	}

	@Test
	void 사다리_생성자에_참가자_수가_음수인_경우() {
		assertThrows(IllegalArgumentException.class, () -> new Ladder(-1,5));
	}

	@Test
	void 사다리_생성자에_사다리의_높이가_음수인_경우() {
		assertThrows(IllegalArgumentException.class, () -> new Ladder(5,-1 ));
	}
}