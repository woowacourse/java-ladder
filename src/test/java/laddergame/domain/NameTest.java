package laddergame.domain;

import org.junit.jupiter.api.Test;

import static laddergame.TestDummy.NAME_ROSIE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class NameTest {
	@Test
	void throwExceptionWhenNameIsBlank() {
		final String valueBlank = " ";
		assertThatThrownBy(() -> new Name(valueBlank))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void throwExceptionWhenNameIsNull() {
		assertThatThrownBy(() -> new Name(null))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void throwExceptionWhenNameOverLength() {
		final String value = "123456";
		assertThatThrownBy(() -> new Name(value))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void create() {
		final String value = "12345";
		assertDoesNotThrow(() -> new Name(value));
	}

	@Test
	void getName() {
		assertThat(NAME_ROSIE.getValue()).isEqualTo("rosie");
	}
}