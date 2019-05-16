package ladder.domain;

public class Player {
	private String name;
	private int initialPosition;
	private int lastPosition;

	public Player(String name, int initialPosition, int lastPosition) {
		this.name = name;
		this.initialPosition = initialPosition;
		this.lastPosition = lastPosition;
	}

	public int getMyResult(Ladder ladder) {
		return ladder.getLastPosition(initialPosition);
	}

	public int getLastPosition() {
		return lastPosition;
	}

	public boolean matchName(String name) {
		return this.name.equals(name);
	}

	public String getName() {
		return name;
	}
}
