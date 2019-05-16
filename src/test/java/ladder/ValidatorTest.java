package ladder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
	@Test
	void 글자수_5자_초과인_값이_없을_경우() {
		assertDoesNotThrow(() -> Validator.checkNamesLength(Arrays.asList("pobi", "crong")));
	}

	@Test
	void 글자수_5자_초과인_값이_있을_경우_예외_반환() {
		assertThrows(IllegalArgumentException.class, () -> Validator.checkNamesLength(Arrays.asList("pobicrong", "crong")));
	}

	@Test
	void 사다리_높이값이_숫자인_경우() {
		assertDoesNotThrow(() -> Validator.checkLadderHeight("19"));
	}

	@Test
	void 사다리_높이값이_숫자가_아닌_경우_예외_반환() {
		assertThrows(NumberFormatException.class, () -> Validator.checkLadderHeight("a"));
	}
}
