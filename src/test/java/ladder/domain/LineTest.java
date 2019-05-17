package ladder.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {
	@Test
	void 생성자에_잘못된_값이_입력된_경우() {
		List<Boolean> points = Arrays.asList(true, true, false);
		assertThrows(IllegalArgumentException.class, () -> new Line(points));
	}

	@Test
	void 생성자에_올바른_값이_입력된_경우() {
		List<Boolean> points = Arrays.asList(false, true, false);
		assertDoesNotThrow(() -> new Line(points));
	}
}

