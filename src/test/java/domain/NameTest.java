package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

	@ParameterizedTest
	@ValueSource(strings = {"안녕하세요", "상돌12", "poBi1"})
	@DisplayName("이름이 주어지면, 올바르게 생성된다.")
	void validNameCreationTest(String name) {
		assertDoesNotThrow(() -> new Name(name));
	}

	@ParameterizedTest
	@CsvSource(value = {"''", "abcdef", "abcdefg", "NULL"}, nullValues = {"NULL"})
	@DisplayName("올바르지 않은 이름이 주어지면, 예외를 발생한다.")
	void invalidNameLengthCreationTest(String name) {
		assertThatThrownBy(() -> new Name(name))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("이름은 1자 이상 5자 이하여야 합니다.");
	}
}
