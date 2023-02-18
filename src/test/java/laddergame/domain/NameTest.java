package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static laddergame.TestDummy.NAME_ROSIE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("이름")
class NameTest {

	@DisplayName("값이 비어있으면 예외가 발생한다.")
	@Test
	void throwExceptionWhenNameIsEmpty() {
		final String valueEmpty = "";
		assertThatThrownBy(() -> new Name(valueEmpty))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("값이 공백이면 예외가 발생한다.")
	@Test
	void throwExceptionWhenNameIsBlank() {
		final String valueBlank = " ";
		assertThatThrownBy(() -> new Name(valueBlank))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("값이 알파벳이 아니면 예외가 발생한다.")
	@Test
	void throwExceptionWhenNameIsNotAlphabet() {
		final String valueBlank = "한글훈글";
		assertThatThrownBy(() -> new Name(valueBlank))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("값이 null이면 예외가 발생한다.")
	@Test
	void throwExceptionWhenNameIsNull() {
		assertThatThrownBy(() -> new Name(null))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("값이 길이를 초과하면 예외가 발생한다.")
	@Test
	void throwExceptionWhenNameOverLength() {
		final String value = "rosieee";
		assertThatThrownBy(() -> new Name(value))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("생성된다.")
	@Test
	void create() {
		final String value = "rosie";
		assertDoesNotThrow(() -> new Name(value));
	}

	@DisplayName("값을 가져온다.")
	@Test
	void getName() {
		assertThat(NAME_ROSIE.getValue()).isEqualTo("rosie");
	}
}
