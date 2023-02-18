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
		//given
		final String valueEmpty = "";

		//when
		//then
		assertThatThrownBy(() -> new Name(valueEmpty))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("값이 공백이면 예외가 발생한다.")
	@Test
	void throwExceptionWhenNameIsBlank() {
		//given
		final String valueBlank = " ";

		//when
		//then
		assertThatThrownBy(() -> new Name(valueBlank))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("값이 알파벳이 아니면 예외가 발생한다.")
	@Test
	void throwExceptionWhenNameIsNotAlphabet() {
		//given
		final String valueBlank = "한글훈글";

		//when
		//then
		assertThatThrownBy(() -> new Name(valueBlank))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("값이 null이면 예외가 발생한다.")
	@Test
	void throwExceptionWhenNameIsNull() {
		//given
		final String nullValue = null;

		//when
		//then
		assertThatThrownBy(() -> new Name(nullValue))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("값이 길이를 초과하면 예외가 발생한다.")
	@Test
	void throwExceptionWhenNameOverLength() {
		//given
		final String value = "rosieee";

		//when
		//then
		assertThatThrownBy(() -> new Name(value))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("생성된다.")
	@Test
	void create() {
		// given
		final String value = "rosie";

		//when
		//then
		assertDoesNotThrow(() -> new Name(value));
	}

	@DisplayName("값을 가져온다.")
	@Test
	void getName() {
		//given
		final String rosieName = NAME_ROSIE.getValue();

		//when
		//then
		assertThat(rosieName).isEqualTo("rosie");
	}
}
