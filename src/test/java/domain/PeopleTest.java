package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사람들은 ")
class PeopleTest {
	@DisplayName("2~10 명이다")
	@Test
	void peopleSizeBetween2_10() {
		People people = People.from(List.of("salmn", "kiara"));

		assertThat(people.size()).isBetween(2, 10);
	}

	@DisplayName("2명 미만이면 예외가 발생한다")
	@Test
	void peopleSize1() {
		assertThatThrownBy(() -> People.from(List.of("kiara")))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("[ERROR] 사람은 2 ~ 10 명이여야 합니다");
	}

	@DisplayName("10명 초과면 예외가 발생한다")
	@Test
	void peopleSize11() {
		List<String> names = IntStream.range(0, 11)
			.mapToObj(i -> "kia" + i)
			.collect(Collectors.toList());

		assertThatThrownBy(() -> People.from(names))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("[ERROR] 사람은 2 ~ 10 명이여야 합니다");
	}

	@DisplayName("중복된 이름은 예외가 발생한다")
	@Test
	void duplication() {
		assertThatThrownBy(() -> People.from(List.of("kiara", "kiara")))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("[ERROR] 이름은 중복되지 않아야 합니다");
	}

	@DisplayName("참여자의 이름을 입력해서 초기 위치를 구할 수 있다")
	@Test
	void getPersonPosition() {
		List<String> names = List.of("abc", "def");
		People people = People.from(names);

		assertThat(names).map(people::getPosition).isEqualTo(List.of(0, 1));
	}

	@DisplayName("참여자의 이름을 잘못 입력하면 초기 위치를 구할 때 예외가 발생한다")
	@Test
	void getNotExistPersonPosition() {
		List<String> names = List.of("abc", "def");
		People people = People.from(names);

		assertThatThrownBy(() -> people.getPosition("nothing"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("[ERROR] 존재하지 않는 참여자입니다");
	}
}
