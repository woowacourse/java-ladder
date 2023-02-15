package domain;

import java.util.ArrayList;
import java.util.List;

public class Participants {

	// TODO: magic number 1, 5를 상수화
	private final List<String> names = new ArrayList<>();

	public void add(final String name) {
		validateIsBlank(name);
		validateNameLength(name);
		names.add(name);
	}

	private void validateIsBlank(final String name) {
		if (name.isBlank()) {
			throw new IllegalArgumentException("참가자의 이름은 공백일 수 없습니다.");
		}
	}

	private void validateNameLength(final String name) {
		if (1 > name.length() || name.length() > 5) {
			throw new IllegalArgumentException("참가자의 이름은 1글자 이상 5글자 이하여야 한다.");
		}
	}
}

