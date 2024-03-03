package domain.prize;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PrizeTest {

	@ParameterizedTest
	@ValueSource(strings = {"", "abcdef"})
	@DisplayName("이름 길이가 올바르지 않으면, 예외가 발생된다.")
	void invalidNameLengthTest(String name) {
		assertThatThrownBy(() -> new Prize(name))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
