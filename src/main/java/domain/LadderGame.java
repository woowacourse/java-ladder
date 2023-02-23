package domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private final Players players;
    private final Ladder ladder;

    public LadderGame(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public boolean moveRight(Line line, Position position) {
        if (position.getIndex() == line.getPointsSize()) {
            return false;
        }
        if (line.isMovablePoint(position.getIndex())) {
            position.moveRight();
            return true;
        }
        return false;
    }

    public boolean moveLeft(Line line, Position position) {
        if (position.getIndex() == 0) {
            return false;
        }
        if (line.isMovablePoint(position.getIndex() - 1)) {
            position.moveLeft();
            return true;
        }
        return false;
    }

    public void move(Line line, Position position) {
        if (moveRight(line, position)) {
            return;
        }
        moveLeft(line, position);
    }

    public int getResultIndex(String name){
        int playerIndex = players.getOrder(name);
        Position position = new Position(playerIndex);
        for(Line line: ladder.getLines()){
            move(line,position);
        }
        return position.getIndex();
    }

    public List<Integer> getResultAllIndex() {
        return players.getNames().stream()
                .map(this::getResultIndex).collect(Collectors.toList());
    }
}
