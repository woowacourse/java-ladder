package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {
	@Test
	void 정상작동() {
		assertDoesNotThrow(() -> new Player("pobi"));
	}

	@Test
	void 참가자_이름이_all인_경우_예외_반환() {
		assertThrows(IllegalArgumentException.class, () -> new Player("all"));
	}

	@Test
	void 참가자_이름이_빈칸인_경우_예외_반환() {
		assertThrows(IllegalArgumentException.class, () -> new Player(""));
	}

	@Test
	void 참가자_이름이_공백으로만_이루어진_경우_예외_반환() {
		assertThrows(IllegalArgumentException.class, () -> new Player("    "));
	}
}
