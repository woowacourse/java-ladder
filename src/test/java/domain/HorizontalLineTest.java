package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HorizontalLineTest {

	@ParameterizedTest
	@ValueSource(ints = {2, 10})
	@DisplayName("올바른 범위의 수가 주어지면, 세로줄을 생성한다.")
	void validPlayerCountCreationTest(int playerCount) {
		assertDoesNotThrow(() -> new HorizontalLine(playerCount));
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 11})
	@DisplayName("올바르지 않은 범위의 수가 주어지면, 예외를 발생한다.")
	void invalidPlayerCountCreationTest(int playerCount) {
		assertThatThrownBy(() -> new HorizontalLine(playerCount))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("플레이어 수 범위는 2 이상 10 이하여야 합니다.");
	}
}