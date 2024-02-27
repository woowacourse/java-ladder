package domain;

import java.util.List;

public class Player {

	private final Name name;
	private int position;

	public Player(String name, int position) {
		this.name = new Name(name);
		this.position = position;
	}

	public void playLadder(Ladder ladder) {
		List<HorizontalLine> lines = ladder.getLines();
		lines.forEach(this::move);
	}

	private void move(HorizontalLine line) {
		Bar bar = line.getBar(position);
		if (bar.isConnectedToRight()) {
			position++;
			return;
		}
		if (bar.isConnectedToLeft()) {
			position--;
		}
	}

	public String getName() {
		return name.value();
	}

	public int getPosition() {
		return position;
	}
}