package domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("예상 실행 결과는")
class ResultTest {
	@DisplayName("앞 뒤 공백을 제외하고 1 ~ 5 글자이다")
	@Test
	void sequenceLength1_5() {
		String sequence = "꽝";
		Result result = new Result(sequence);

		assertThat(result.getSequence().trim())
			.hasSizeBetween(1, 5);
	}
}
