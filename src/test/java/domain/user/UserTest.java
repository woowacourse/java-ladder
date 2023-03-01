package domain.user;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserTest {
	@ParameterizedTest
	@DisplayName("이름이 한 글자 이상, 다섯 글자 이하인 참가자는 정상적으로 생성되어야 한다.")
	@ValueSource(ints = {1, 2, 3, 4, 5})
	void userNameLengthSuccessTest(int nameLength) {
		String name = "1".repeat(nameLength);
		Assertions.assertDoesNotThrow(() -> new User(name));
	}

	@ParameterizedTest
	@DisplayName("0 글자 또는 6 글자인 참가자 이름은 예외를 발생시켜야 한다.")
	@ValueSource(ints = {0, 6})
	void userNameLengthFailTest(int nameLength) {
		String name = "1".repeat(nameLength);
		assertThatThrownBy(() -> new User(name)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("이름이 공백인 참가자는 예외를 발생시켜야 한다.")
	void userNameLengthFailTest2() {
		String name = "  ";
		assertThatThrownBy(() -> new User(name)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("'all' 이라는 이름의 참가자를 생성하면 예외가 발생해야 한다.")
	void userNameAllTest() {
		String name = "all";
		assertThatThrownBy(() -> new User(name)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("user 객체의 name 필드가 같다면 같은 객체로 인식해야 한다.")
	void equalsTest() {
		User user1 = new User("user");
		User user2 = new User("user");
		assertThat(user1).isEqualTo(user2);
	}
}
