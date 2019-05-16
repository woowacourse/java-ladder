package ladder.domain;

public class Player {
	private String name;

	public Player(String name) {
		this.name = name;
	}

	public boolean matchName(String name) {
		return this.name.equals(name);
	}

	@Override
	public String toString() {
		return name;
	}
}
