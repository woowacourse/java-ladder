package ladder.domain;

public class Player {
    private UserName userName;
    private LineNumber currentLineNumber;
    private LineFloor currentLineFloor;

    public Player(final UserName userName, final LineNumber currentLineNumber, final LineFloor currentLineFloor) {
        this.userName = userName;
        this.currentLineNumber = currentLineNumber;
        this.currentLineFloor = currentLineFloor;
    }
}
