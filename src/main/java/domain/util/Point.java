package domain.util;

public enum Point implements Display {

	PRESENCE(true),
	ABSENCE(false);

	private final static String ABSENT_LINE = "     ";
	private final static String PRESENT_LINE = "-----";

	private final boolean presence;

	Point(boolean presence) {
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

	@Override
	public String format() {
		if (presence) {
			return PRESENT_LINE;
		}
		return ABSENT_LINE;
	}
}
