package domain.util;

public enum Point {
	PRESENCE(true),
	ABSENCE(false);

	private boolean presence;

	Point(final boolean presence){
		this.presence = presence;
	}

	public boolean isPresent() {
		return presence;
	}

	public static Point from(boolean present) {
		if (present) {
			return Point.PRESENCE;
		}
		return Point.ABSENCE;
	}
}
