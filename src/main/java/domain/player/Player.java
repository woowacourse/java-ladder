package domain.player;

import domain.validator.NameValidator;

public class Player {

	private final String name;
	private int position;

	public Player(String name, int position) {
		validateName(name);
		this.name = name;
		this.position = position;
	}

	public void moveRight() {
		position++;
	}

	public void moveLeft() {
		if (position == 0) {
			throw new IllegalArgumentException("왼쪽으로 이동할 수 없습니다.");
		}

		position--;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	private void validateName(String name) {
		NameValidator validator = NameValidator.getInstance();
		validator.validate(name);
	}
}
