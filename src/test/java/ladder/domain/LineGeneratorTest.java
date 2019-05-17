package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineGeneratorTest {

	@Test
	void 생성자에_올바른_값이_입력된_경우() {
		assertDoesNotThrow(() -> new LineGenerator(5));
	}

	@Test
	void 생성자에_0이하의_값이_입력된_경우() {
		assertThrows(IllegalArgumentException.class, () -> new LineGenerator(0));
	}
}