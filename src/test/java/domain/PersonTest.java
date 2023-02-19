package domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("사람 이름은 ")
class PersonTest {
	@DisplayName("앞 뒤 공백을 제외하고 1 ~ 5 글자이다")
	@Test
	void nameLength1_5() {
		String name = "kiara";
		Person person = new Person(name);

		assertThat(person.getName().trim()).hasSizeBetween(1, 5);
	}

	@DisplayName("앞뒤 공백을 제외하고 1 ~ 5글자가 아니면 예외가 발생한다")
	@ParameterizedTest
	@ValueSource(strings = {"", "  ", "helloWorld"})
	void nameLengthNot1_5(String name) {
		assertThatThrownBy(() -> new Person(name))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 이름은 1 ~ 5글자만 가능합니다");
	}
}
