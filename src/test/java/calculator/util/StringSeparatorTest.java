package calculator.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringSeparatorTest {
	@Test
	void 쉼표로_문자열_구분하기() {
		assertThat(StringSeparator.splitString("1,2,3")).isEqualTo(new String[]{"1", "2", "3"});
	}

	@Test
	void 콜론으로_문자열_구분하기() {
		assertThat(StringSeparator.splitString("1:2:3")).isEqualTo(new String[]{"1", "2", "3"});
	}

	@Test
	void 쉼표와_콜론으로_문자열_구분하기() {
		assertThat(StringSeparator.splitString("1:2,3")).isEqualTo(new String[]{"1", "2", "3"});
	}

	@Test
	void 커스텀_구분자로_문자열_구분하기() {
		assertThat(StringSeparator.splitString("//#\n1#2#3")).isEqualTo(new String[]{"1", "2", "3"});
	}

	@Test
	void 쉼표와_콜론과_커스텀_구분자로_문자열_구분하기() {
		assertThat(StringSeparator.splitString("//#\n1#2,3:4")).isEqualTo(new String[]{"1", "2", "3", "4"});
	}

	@Test
	void 숫자_하나를_입력한_경우_문자열_구분() {
		assertThat(StringSeparator.splitString("1")).isEqualTo(new String[]{"1"});
	}

	@Test
	void Null을_입력한_경우_문자열_구분값() {
		assertThat(StringSeparator.splitString(null)).isEqualTo(new String[]{});
	}

	@Test
	void 빈_문자열을_입력한_경우_문자열_구분값() {
		assertThat(StringSeparator.splitString("")).isEqualTo(new String[]{});
	}

}