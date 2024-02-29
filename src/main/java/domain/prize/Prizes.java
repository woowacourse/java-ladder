package domain.prize;

import java.util.List;

import domain.validator.NameValidator;

public record Prizes(List<String> names) {

	public Prizes {
		names.forEach(this::validateName);
	}

	public String getPlayersPrizeName(int playerFinalPosition) {
		validatePosition(playerFinalPosition);
		return names.get(playerFinalPosition);
	}

	private void validatePosition(int playerFinalPosition) {
		if (playerFinalPosition < 0 || playerFinalPosition >= names.size()) {
			throw new IllegalArgumentException("올바른 위치값이 아닙니다.");
		}
	}

	@Override
	public List<String> names() {
		return List.copyOf(names);
	}

	private void validateName(String name) {
		NameValidator validator = NameValidator.getInstance();
		validator.validate(name);
	}
}
