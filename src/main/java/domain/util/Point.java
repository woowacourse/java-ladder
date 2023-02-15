package domain.util;

public enum Point {
	PRESENCE(true),
	ABSENCE(false);

	private boolean presence;

	Point(boolean presence){
		this.presence = presence;
	}

	public boolean isPresent() {
		return presence;
	}
}
