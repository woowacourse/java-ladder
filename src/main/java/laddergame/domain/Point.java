package laddergame.domain;

public class Point {
	private final boolean point;

	public Point(boolean b) {
		this.point = b;
	}

	public boolean booleanValue() {
		return this.point;
	}

	@Override
	public String toString() {
		return point ? "-----" : "     ";
	}
}
