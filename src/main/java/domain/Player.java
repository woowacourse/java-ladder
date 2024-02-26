package domain;

public class Player {

	private final Name name;
	private int position;

	public Player(String name, int position) {
		this.name = new Name(name);
		this.position = position;
	}

	public void move(HorizontalLine line) {
		Bar bar = line.getBar(position);
		if (bar.isConnectedToLeft()) {
			position--;
			return;
		}
		if (bar.isConnectedToRight()) {
			position++;
		}
	}

	public String getName() {
		return name.value();
	}

	public int getPosition() {
		return position;
	}
}
