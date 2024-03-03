package domain.ladder;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderHeightTest {

	@ParameterizedTest
	@ValueSource(ints = {0, 11})
	@DisplayName("사다리의 높이가 1 이상 10 이하가 아닌 경우 예외를 발생시킨다.")
	void ladderCreationTestWithInvalidHeight(int height) {
		assertThatThrownBy(() -> new LadderHeight(height))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("사다리의 높이는 1 이상 10 이하여야 합니다.");
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 10})
	@DisplayName("사다리의 높이가 올바른 경우 예외를 발생시키지 않는다.")
	void ladderCreationTest(int height) {
		assertDoesNotThrow(() -> new LadderHeight(height));
	}
}
