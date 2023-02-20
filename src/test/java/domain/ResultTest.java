package domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("예상 실행 결과는")
class ResultTest {
	@DisplayName("앞 뒤 공백을 제외하고 1 ~ 5 글자이다")
	@Test
	void sequenceLength1_5() {
		String sequence = "꽝";
		Result result = new Result(sequence);

		assertThat(result.getSequence().trim()).hasSizeBetween(1, 5);
	}

	@DisplayName("앞뒤 공백을 제외하고 1 ~ 5글자가 아니면 예외가 발생한다")
	@ParameterizedTest
	@ValueSource(strings = {"", "  ", "600000", "당첨되셨습니다"})
	void sequenceLengthNot1_5(String sequence) {
		assertThatThrownBy(() -> new Result(sequence)).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 예상 결과는 1 ~ 5글자만 가능합니다");
	}
}
