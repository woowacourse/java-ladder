package domain;

import java.util.LinkedHashMap;
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

		Map<User, End> expected = new LinkedHashMap<>();
		int size = users.size();
		for (int i = 0; i < size; i++) {
			expected.put(users.get(i), ends.get(changeIdx.get(i)));
		}
		Map<User, End> mappedResult = ResultMapper.map(users, ends, changeIdx);

		Assertions.assertThat(mappedResult).containsExactlyEntriesOf(expected);
	}
}
