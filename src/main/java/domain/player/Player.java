package domain.player;

import java.util.regex.Pattern;

public class Player {

	private static final Pattern NAME_REGEX = Pattern.compile("^[A-Za-z가-힣0-9]*$");
	private static final int MAX_NAME_LENGTH = 5;

	private final String name;
	private int position;

	public Player(String name, int position) {
		validate(name);
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

	public void validate(String name) {
		validateLength(name);
		validatePattern(name);
	}

	private void validateLength(String name) {
		if (name == null || isNameLengthOutOfRange(name)) {
			throw new IllegalArgumentException("이름은 1자 이상 5자 이하여야 합니다.");
		}
	}

	private boolean isNameLengthOutOfRange(String name) {
		return name.isEmpty() || name.length() > MAX_NAME_LENGTH;
	}

	private void validatePattern(String name) {
		boolean isPatternMatches = NAME_REGEX.matcher(name).matches();
		if (!isPatternMatches) {
			throw new IllegalArgumentException("이름은 영문, 한글, 숫자로만 구성할 수 있습니다.");
		}
	}
}
