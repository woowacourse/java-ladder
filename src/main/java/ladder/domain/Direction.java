package ladder.domain;

public enum Direction {
	LEFT(-1),
	RIGHT(1),
	STOP(0);

	private int direction;

	Direction(final int direction) {
		this.direction = direction;
	}

	public int getDirection() {
		return this.direction;
	}
}
