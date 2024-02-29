package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import domain.validator.NameValidator;

class NameValidatorTest {

	NameValidator validator;

	@BeforeEach
	void setUP() {
		validator = NameValidator.getInstance();
	}

	@ParameterizedTest
	@ValueSource(strings = {"안녕하세요", "상돌12", "poBi1"})
	@DisplayName("올바르게 주어진 이름에 대해서는 예외를 발생시키지 않는다.")
	void validNameCreationTest(String name) {
		assertDoesNotThrow(() -> validator.validate(name));
	}

	@ParameterizedTest
	@CsvSource(value = {"''", "abcdef", "abcdefg", "NULL"}, nullValues = {"NULL"})
	@DisplayName("올바르지 않은 이름이 주어지면, 예외를 발생한다.")
	void invalidNameLengthCreationTest(String name) {
		assertThatThrownBy(() -> validator.validate(name))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("이름은 1자 이상 5자 이하여야 합니다.");
	}
}
