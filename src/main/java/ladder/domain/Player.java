package ladder.domain;

import java.util.List;

public class Player {
	private String name;
	private int position;

	public Player(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public int trymove(List<Boolean> points) {
		if (position == 0) {
			return moveRight();
		}
		if (position == points.size() - 1) {
			return moveLeft();
		}
		if (points.get(position - 1)) {
			return moveLeft();
		}
		return moveRight();
	}

	private int moveLeft() {
		position --;
		return position;
	}

	private int moveRight() {
		position++;
		return position;
	}

	public boolean matchName(String name) {
		return this.name.equals(name);
	}


}
