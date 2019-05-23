package laddergame.domain.ladder;

public class Point {
	public static final boolean CONNECT = true;
	public static final boolean DISCONNECT = false;

	private final boolean bridge;

	private Point(final boolean bridge) {
		this.bridge = bridge;
	}

	public static Point of(final boolean bridge) {
		return new Point(bridge);
	}

	public boolean hasBridge() {
		return this.bridge;
	}
}
