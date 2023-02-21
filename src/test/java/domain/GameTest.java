package domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameTest {
	private Map<String, String> resultMap;

	@BeforeEach
	public void beforeEach() {
		resultMap = new HashMap<>();
		resultMap.put("ga", "one");
		resultMap.put("na", "two");
		resultMap.put("da", "three");
		resultMap.put("la", "four");
	}

	@DisplayName("참여자 중에서만 검색이 가능하다")
	@ParameterizedTest
	@ValueSource(strings = {"ga", "na", "da", "la"})
	void searchInParticipants(String people) {
		assertThat(resultMap.containsKey(people)).isTrue();
	}
}
