package laddergame.domain.ladder;

public enum NewDirection {

	LEFT_MOVE(-1),
	RIGHT_MOVE(1),
	KEEP_MOVE(0);

	private final int direction;

	private NewDirection(final int direction) {
		this.direction = direction;
	}

	public int move() {
		return this.direction;
	}
}
