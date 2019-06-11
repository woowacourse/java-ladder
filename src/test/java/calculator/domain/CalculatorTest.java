package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
	@Test
	void 구분한_문자열의_합_구하기() {
		assertThat(Calculator.sumValues(new String[]{"1", "2", "3"})).isEqualTo(6);
	}

	@Test
	void 숫자_하나를_입력한_경우_합() {
		assertThat(Calculator.sumValues(new String[]{"1"})).isEqualTo(1);
	}

	@Test
	void 빈_문자열_배열을_입력한_경우_합() {
		assertThat(Calculator.sumValues(new String[]{})).isEqualTo(0);
	}

	@Test
	void 입력된_문자열이_음수인_경우() {
		assertThrows(RuntimeException.class, () -> Calculator.checkCorrectValue(new String[]{"-1", "1", "2"}));
	}

	@Test
	void 입력된_문자열이_문자인_경우() {
		assertThrows(RuntimeException.class, () -> Calculator.checkCorrectValue(new String[]{"a", "1", "2"}));
	}
}
