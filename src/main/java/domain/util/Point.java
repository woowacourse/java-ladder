package domain.util;

public enum Point {
	PRESENT(true),
	ABSENCE(false);

	private boolean presence;

	Point(boolean presence){
		this.presence = presence;
	}

	public boolean isPresent() {
		return presence;
	}
}
