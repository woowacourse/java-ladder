package domain.util;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import domain.end.End;
import domain.user.User;

public class ResultMapper {

	public static Map<User, End> map(final List<User> users,
			final List<End> ends,
			final List<Integer> indicies) {
		Map<User, End> map = new LinkedHashMap<>();
		int size = users.size();
		for (int i = 0; i < size; i++) {
			map.put(users.get(i), ends.get(indicies.get(i)));
		}
		return map;
	}
}
