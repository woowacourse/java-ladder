package domain;

public class LadderGame {
    private final Players players;
    private final Ladder ladder;

    public LadderGame(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }


    public void moveRight(Line line, Position position) {
        if(line.isMovablePoint(position.getIndex())){
            position.moveRight();
        }
    }
}
