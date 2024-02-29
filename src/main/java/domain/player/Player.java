package domain.player;

import domain.LineFloor;
import domain.LineNumber;

public class Player {
    private final PlayerName playerName;

    private LineNumber currentLineNumber;
    private LineFloor currentLineFloor;

    public Player(final PlayerName playerName, final LineNumber currentLineNumber, final LineFloor currentLineFloor) {
        this.playerName = playerName;
        this.currentLineNumber = currentLineNumber;
        this.currentLineFloor = currentLineFloor;
    }

    public static Player of(String userName, int lineNumber, int lineFloor) {
        return new Player(new PlayerName(userName), new LineNumber(lineNumber), new LineFloor(lineFloor));
    }

    public boolean escapeLadder() {
        return currentLineFloor.isZero();
    }

    public void move(int moveDistance) {
        currentLineNumber = new LineNumber(currentLineNumber.value() + moveDistance);
        currentLineFloor = new LineFloor(currentLineFloor.value() - 1);
    }

    public LineNumber getCurrentLineNumber() {
        return currentLineNumber;
    }

    public LineFloor getCurrentLineFloor() {
        return currentLineFloor;
    }

    public PlayerName getPlayerName() {
        return playerName;
    }
}
