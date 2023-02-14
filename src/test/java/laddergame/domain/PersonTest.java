package laddergame.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
}