package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrizeTest {

	@ParameterizedTest
	@CsvSource(value = {"''", "abcdef", "1000000", "사다리게임결과", "NULL"}, nullValues = {"NULL"})
	@DisplayName("올바르지 않은 상품 이름이 입력되면, 예외가 발생된다.")
	void invalidNameLengthCreationTest(String name) {
		assertThatThrownBy(() -> new Prize(name))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("이름은 1자 이상 5자 이하여야 합니다.");
	}
}