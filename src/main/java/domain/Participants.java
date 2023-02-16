package domain;

import java.util.ArrayList;
import java.util.List;

public class Participants {

	private static final int MIN_NAME_LENGTH = 1;
	private static final int MAX_NAME_LENGTH = 5;

	private final List<String> names = new ArrayList<>();

	public void add(final String name) {
		validateIsBlank(name);
		validateNameLength(name);
		names.add(name);
	}

	private void validateIsBlank(final String name) {
		if (name.isBlank()) {
			throw new IllegalArgumentException("[ERROR]: 참가자의 이름은 공백일 수 없습니다.");
		}
	}

	private void validateNameLength(final String name) {
		if (MIN_NAME_LENGTH > name.length() || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("[ERROR]: 참가자의 이름은 1글자 이상 5글자 이하여야 한다.");
		}
	}

	public int getParticipantsNum() {
		return names.size();
	}

	public List<String> getNames(){
		return this.names;
	}
}

