package ladder.domain;

public class Player {
    private PlayerName playerName;
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
}
