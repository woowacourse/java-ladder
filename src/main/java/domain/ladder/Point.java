package domain.ladder;

public enum Point {
	PRESENCE(true),
	ABSENCE(false);

	private final boolean presence;

	Point(final boolean presence){
		this.presence = presence;
	}

	public boolean isPresent() {
		return presence;
	}

	public static Point from(final boolean present) {
		if (present) {
			return Point.PRESENCE;
		}
		return Point.ABSENCE;
	}
}
