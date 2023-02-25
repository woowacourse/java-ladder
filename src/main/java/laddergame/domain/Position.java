package laddergame.domain;

import java.util.List;

public class Position {

    private int position;

    public Position(int position, int userCount) {
        validateInitialPosition(position, userCount);
        this.position = position;
    }

    public void moveByConnectionStatus(LineImpl line) {
        List<PointImpl> points = line.getPoints();

        if (isMovableToRight(points)) {
            position++;
            return;
        }
        if (isMovableToLeft(points)) {
            position--;
        }
    }

    private void validateInitialPosition(int position, int userCount) {
        if (position < 0 || position >= userCount) {
            throw new IllegalArgumentException("유저의 위치는 0 이상, 총 유저 수 미만이어야 합니다.");
        }
    }

    private boolean isMovableToRight(List<PointImpl> points) {
        return position < points.size() && points.get(position).isConnected();
    }

    private boolean isMovableToLeft(List<PointImpl> points) {
        return position > 0 && points.get(position - 1).isConnected();
    }

    public int getPosition() {
        return position;
    }
}
