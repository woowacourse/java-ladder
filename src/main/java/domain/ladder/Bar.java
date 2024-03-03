package domain.ladder;

public enum Bar {
	CONNECTED_TO_LEFT,
	CONNECTED_TO_RIGHT,
	NOT_CONNECTED;

	public boolean isConnectedToRight() {
		return this == CONNECTED_TO_RIGHT;
	}

	public boolean isConnectedToLeft() {
		return this == CONNECTED_TO_LEFT;
	}
}
