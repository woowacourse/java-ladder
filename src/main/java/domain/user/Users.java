package domain.user;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
	private static final int MIN_USERS = 2;
	private static final String NAME_TOO_FEW_ERROR_MSG = "최소 두 명 이상의 참가자 이름을 입력해야 합니다.";
	private static final String NAME_DUPLICATED_ERROR_MSG = "중복된 참가자 이름을 사용할 수 없습니다.";
	private final List<User> names;

	public Users(final List<String> userNames) {
		validateNameCount(userNames);
		validateDuplicatedNames(userNames);
		names = wrapUserNames(userNames);
	}

	private void validateNameCount(final List<String> userNames) {
		if (userNames.size() < MIN_USERS) {
			throw new IllegalArgumentException(NAME_TOO_FEW_ERROR_MSG);
		}
	}

	private void validateDuplicatedNames(final List<String> userNames) {
		if (userNames.size() != userNames.stream().distinct().count()) {
			throw new IllegalArgumentException(NAME_DUPLICATED_ERROR_MSG);
		}
	}

	private List<User> wrapUserNames(final List<String> userNames) {
		return userNames.stream()
			.map(User::new)
			.collect(Collectors.toList());
	}

	public int getUsersCount() {
		return names.size();
	}

	public List<User> getUsers() {
		return Collections.unmodifiableList(names);
	}
}

