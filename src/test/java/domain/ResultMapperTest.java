package domain;

import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.end.End;
import domain.end.Ends;
import domain.user.User;
import domain.user.Users;

class ResultMapperTest {

	@Test
	@DisplayName("원하는 인덱스로 user-end쌍이 매핑되어야 한다.")
	void indexMatchTest() {
		List<User> users = new Users(List.of("a", "b", "c", "d")).getUsers();
		List<End> ends = new Ends(List.of("가", "나", "다", "라")).getEnds();
		List<Integer> changeIdx = List.of(1, 0, 3, 2);

		Map<User, End> expected = Map.of(users.get(0), ends.get(1),
			users.get(1), ends.get(0),
			users.get(2), ends.get(3),
			users.get(3), ends.get(2));

		ResultMapper resultMapper = new ResultMapper();
		Map<User, End> mappedResult = resultMapper.map(users, ends, changeIdx);

		Assertions.assertThat(mappedResult).containsExactlyEntriesOf(expected);
	}
}
