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

    public void moveLeft(Line line, Position position) {
        if(line.isMovablePoint(position.getIndex() - 1)){
            position.moveLeft();
        }
    }

    // todo : if문 이용하기
    public void move(Line line, Position position) {
        moveRight(line,position);
        moveLeft(line,position);
    }

}
