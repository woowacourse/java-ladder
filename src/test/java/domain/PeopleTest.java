package domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사람들은 ")
class PeopleTest {
	@DisplayName("2~10 명이다")
	@Test
	void peopleSizeBetween2_10() {
		People people = new People(List.of("salmn", "kiara"));

		assertThat(people.getPeople().size()).isBetween(2, 10);
	}

	@DisplayName("2명 미만이면 예외가 발생한다")
	@Test
	void peopleSize1() {
		assertThatThrownBy(() -> new People(List.of("kiara")))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("사람은 최소 두명 이상이어야 합니다");
	}

	@DisplayName("10명 초과면 예외가 발생한다")
	@Test
	void peopleSize11() {
		List<String> names = IntStream.range(0, 11)
			.mapToObj(i -> "kia" + i)
			.collect(Collectors.toList());

		assertThatThrownBy(() -> new People(names))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("사람은 최대 10명 이어야 합니다");
	}
}
