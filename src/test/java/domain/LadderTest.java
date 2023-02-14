package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("사다리는 ")
class LadderTest {
	@DisplayName("1 이상 100 이하의 높이만 가능하다")
	@ParameterizedTest
	@ValueSource(ints = {1, 50, 100})
	void ladderHeight1_100(int height) {
		Ladder ladder = new Ladder(height);

		assertThat(ladder.getHeight()).isBetween(1, 100);
	}

	@DisplayName("1 이상 100 이하의 높이가 아니면 예외가 발생한다")
	@ParameterizedTest
	@ValueSource(ints = {-2, 101})
	void ladderHeightNot1_100(int height) {
		assertThatThrownBy(() -> new Ladder(height))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
