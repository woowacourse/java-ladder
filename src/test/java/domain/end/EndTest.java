package domain.end;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class EndTest {
	@ParameterizedTest
	@DisplayName("한 글자 이상, 다섯 글자 이하인 결과는 정상적으로 생성되어야 한다.")
	@ValueSource(ints = {1, 5})
	void endLengthSuccessTest(int endLength) {
		String end = "9".repeat(endLength);
		Assertions.assertDoesNotThrow(() -> new End(end));
	}

	@ParameterizedTest
	@DisplayName("0 글자 또는 6 글자인 결과는 예외를 발생시켜야 한다.")
	@ValueSource(ints = {0, 6})
	void endLengthFailTest(int endLength) {
		String end = "9".repeat(endLength);
		assertThatThrownBy(() -> new End(end)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("end 객체의 name 필드가 같다면 같은 객체로 인식해야 한다.")
	void equalsTest() {
		End end1 = new End("end");
		End end2 = new End("end");
		assertThat(end1).isEqualTo(end2);
	}
}
