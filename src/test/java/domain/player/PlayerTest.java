package domain.player;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

	@ParameterizedTest
	@ValueSource(strings = {"", "abcdef", "a-1"})
	@DisplayName("올바르지 않은 플레이어 이름이 주어지면, 예외가 발생한다.")
	void invalidPlayerNameExceptionTest(String name) {
		assertThatThrownBy(() -> new Player(name, 0))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("위치값이 0일때는 왼쪽으로 이동할 수 없다.")
	void moveLeftWhenLocationValueZeroTest() {
		Player player = new Player("A", 0);

		assertThatThrownBy(player::moveLeft)
			.isInstanceOf(IllegalArgumentException.class);
	}
}
