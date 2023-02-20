package domain;

import java.util.List;

public class Player {

    private final Name name;
    private final Position position;

    public Player(String name, int position){
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public String getName() {
        return name.getName();
    }

    public String calculateResult(Ladder ladder, Results results) {
        int currentPosition = position.getPosition();
        List<Line> lines = ladder.getLines();

        for (Line line : lines) {
            List<Boolean> points = line.getPoints();
            currentPosition = progressLine(currentPosition, points);
        }
        return results.getResult(currentPosition);
    }

    private int progressLine(int currentPosition, List<Boolean> points) {
        if (isLeft(currentPosition, points)) {
            return currentPosition - 1;
        }
        if (isRight(currentPosition, points)){
            return currentPosition + 1;
        }
        return currentPosition;
    }

    private boolean isRight(int currentPosition, List<Boolean> points) {
        return !isLastPosition(currentPosition, points) && points.get(currentPosition);
    }

    private static boolean isLastPosition(int currentPosition, List<Boolean> points) {
        return currentPosition == points.size() + 1;
    }

    private boolean isLeft(int currentPosition, List<Boolean> points) {
        return currentPosition != 0 && points.get(currentPosition - 1);
    }
}
