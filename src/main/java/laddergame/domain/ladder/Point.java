package laddergame.domain.ladder;

public class Point {
	private final static String CONNECTED_BRIDGE = "-----";
	private final static String NON_BRIDGE = "     ";
	private final boolean bridge;

	public Point(boolean bridge) {
		this.bridge = bridge;
	}

	public boolean hasBridge() {
		return this.bridge;
	}

	@Override
	public String toString() {
		return bridge ? CONNECTED_BRIDGE : NON_BRIDGE;
	}
}
