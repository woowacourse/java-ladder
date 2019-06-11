package ladder.util;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringSplitUtilsTest {
	@Test
	void 쉼표로_문자열_구분하기() {
		assertThat(StringSplitUtils.splitString("pobi,honux,crong,jk")).isEqualTo(Arrays.asList("pobi", "honux", "crong", "jk"));
	}

	@Test
	void 빈_문자열일_때_예외_반환() {
		assertThrows(IllegalArgumentException.class, () -> StringSplitUtils.splitString(""));
	}

	@Test
	void 문자열이_공백일_때_예외_반환() {
		assertThrows(IllegalArgumentException.class, () -> StringSplitUtils.splitString(" "));
	}

	@Test
	void 문자열이_널일_때_예외_반환() {
		assertThrows(NullPointerException.class, () -> StringSplitUtils.splitString(null));
	}
}