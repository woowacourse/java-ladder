package ladder.validator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
	@Test
	void 글자수_5자_초과인_값이_없을_경우() {
		assertDoesNotThrow(() -> Validator.validateNamesLength(Arrays.asList("pobi", "crong")));
	}

	@Test
	void 글자수_5자_초과인_값이_있을_경우_예외_반환() {
		assertThrows(IllegalArgumentException.class, () -> Validator.validateNamesLength(Arrays.asList("pobicrong", "crong")));
	}

	@Test
	void 사다리_높이값이_숫자인_경우() {
		assertDoesNotThrow(() -> Validator.validateNumber("19"));
	}

	@Test
	void 사다리_높이값이_숫자가_아닌_경우_예외_반환() {
		assertThrows(NumberFormatException.class, () -> Validator.validateNumber("a"));
	}

	@Test
	void 결과_수가_참가자_수와_같을_경우() {
		List<String> players = Arrays.asList("pobi", "crong", "jk");
		List<String> results = Arrays.asList("꽝", "100", "500");
		assertDoesNotThrow(() -> Validator.compareLength(players, results));
	}

	@Test
	void 결과_수가_참가자_수와_다를_경우_예외_반환() {
		List<String> players = Arrays.asList("pobi", "crong");
		List<String> results = Arrays.asList("꽝", "100", "500");
		assertThrows(IllegalArgumentException.class, () -> Validator.compareLength(players, results));
	}
}
