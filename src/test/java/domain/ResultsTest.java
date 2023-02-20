package domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("예상 실행 결과")
class ResultsTest {
	@DisplayName("개수는 참여자의 수와 같아야 한다")
	@Test
	void resultSameAsPeopleSize() {
		People people = People.from(List.of("salmn", "kiara"));
		Results results = Results.from(List.of("꽝", "5000"));

		assertThat(results.size()).isEqualTo(people.size());
	}
}
