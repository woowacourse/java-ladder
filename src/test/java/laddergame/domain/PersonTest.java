package laddergame.domain;

import org.junit.jupiter.api.Test;

import static laddergame.TestDummy.PERSON_ROSIE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PersonTest {
	@Test
	void throwExceptionWhenNameIsBlank() {
		final String nameBlank = " ";
		assertThatThrownBy(() -> new Person(nameBlank))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void throwExceptionWhenNameIsNull() {
		assertThatThrownBy(() -> new Person(null))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void throwExceptionWhenNameOverLength() {
		final String name = "123456";
		assertThatThrownBy(() -> new Person(name))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void create() {
		final String name = "12345";
		assertDoesNotThrow(() -> new Person(name));
	}

	@Test
	void getName() {
		assertThat(PERSON_ROSIE.getName()).isEqualTo("로지");
	}
}