package laddergame.domain;

import static laddergame.TestDummy.PERSONAL_NAME_ROSIE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("이름")
class PersonalNameTest {

	@DisplayName("값이 비어있으면 예외가 발생한다.")
	@Test
	void throwExceptionWhenNameIsEmpty() {
		//given
		final String valueEmpty = "";

		//when
		//then
		assertThatThrownBy(() -> new PersonalName(valueEmpty))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("값이 공백이면 예외가 발생한다.")
	@Test
	void throwExceptionWhenNameIsBlank() {
		//given
		final String valueBlank = " ";

		//when
		//then
		assertThatThrownBy(() -> new PersonalName(valueBlank))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("값이 알파벳이 아니면 예외가 발생한다.")
	@Test
	void throwExceptionWhenNameIsNotAlphabet() {
		//given
		final String valueBlank = "한글훈글";

		//when
		//then
		assertThatThrownBy(() -> new PersonalName(valueBlank))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("값이 null이면 예외가 발생한다.")
	@Test
	void throwExceptionWhenNameIsNull() {
		//given
		final String nullValue = null;

		//when
		//then
		assertThatThrownBy(() -> new PersonalName(nullValue))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("생성된다.")
	@Test
	void create() {
		// given
		final String value = "rosie";

		//when
		//then
		assertDoesNotThrow(() -> new PersonalName(value));
	}

	@DisplayName("값을 가져온다.")
	@Test
	void getName() {
		//given
		final String rosieName = PERSONAL_NAME_ROSIE.getValue();

		//when
		//then
		assertThat(rosieName).isEqualTo("rosie");
	}
}
