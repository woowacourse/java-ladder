package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Random RANDOM = new Random();
    private static final String EMPTY_LINE = "     ";
    private static final String FILLED_LINE = "-----";
    private static final String VERTICAL_LINE = "|";
    private List<Bridge> bridges = new ArrayList<>();

    public Line(int countOfPlayer) {
        this.pointsInit(countOfPlayer);
    }

    private void pointsInit(int countOfPlayer) {
        boolean previous = false;
        for (int i = 0; i < countOfPlayer - 1; i++) {
            previous = nextPoint(previous);
            bridges.add(new Bridge(previous));
        }
        this.checkPointsValid();
    }

    private boolean nextPoint(boolean previous) {
        if (!previous) {
            return RANDOM.nextBoolean();
        }
        return false;
    }

    public int lineSize() {
        return this.bridges.size();
    }

    public void checkPointsValid() {
        for (int i = 1; i < this.lineSize(); i++) {
            checkContinued(i - 1, i);
        }
    }

    private void checkContinued(int left, int right) {
        if (this.isBridgeConnected(left) && this.isBridgeConnected(right)) {
            throw new IllegalArgumentException("이어지는 가로라인 발생");
        }
    }

    public boolean isBridgeConnected(int index) {
        return this.bridges.get(index).isConnected();
    }

    void moveOneLine(Players players) {
        for (Player player : players) {
            this.move(player);
        }
    }

    public void move(Player player) {
        int position = player.getPosition();
        if (position > 0 && this.isBridgeConnected(position - 1)) {
            player.moveLeft();
        }
        if (position < bridges.size() && this.isBridgeConnected(position)) {
            player.moveRight();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(VERTICAL_LINE);
        for (int i = 0; i < lineSize(); i++) {
            stringBuilder.append(this.getOne(i)).append(VERTICAL_LINE);
        }
        return stringBuilder.toString();
    }

    private String getOne(int pointIndex) {
        if (this.isBridgeConnected(pointIndex)) {
            return FILLED_LINE;
        }
        return EMPTY_LINE;
    }
}
