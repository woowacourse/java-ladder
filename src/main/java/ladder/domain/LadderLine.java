package ladder.domain;

import ladder.view.validator.PlayerValidate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 사다리 가로 줄 하나를 만드는 클래스
 * <br> LadderLine ladderLine = new LadderLine(row)
 * <br> ladderLine.movePlayerPosition(players, index)
 *
 * @author heebg, hyojaekim
 * @version 1.0 2019-05-16
 */
public class LadderLine {
    private final int playerCount;
    private List<Point> lineStates;

    /**
     * 생성자. 가로 길이를 입력한다.
     *
     * @param playerCount 가로 길이
     */
    public LadderLine(int playerCount) {
        PlayerValidate.playersMinCount(playerCount);
        this.playerCount = playerCount;
        this.lineStates = addLineStates();
    }

    /**
     * 해당 라인을 실행 한 이후 인덱스를 반환
     *
     * @param position 실행할 인덱스
     * @return index
     */
    public void movePlayerPosition(Player player, int position) {
        if (isLeftLadderLine(position)) {
            player.moveLeft();
        }
        if (isRightLadderLine(position)) {
            player.moveRight();
        }
    }

    private boolean isRightLadderLine(int position) {
        return position != lineStates.size() - 1 && lineStates.get(position + 1).isNowPoint();
    }

    private boolean isLeftLadderLine(int position) {
        return position != 0 && lineStates.get(position).isNowPoint();
    }

    private List<Point> addLineStates() {
        List<Point> lineStates = new ArrayList<>();
        lineStates.add(new Point());
        for (int i = 1; i < playerCount; i++) {
            lineStates.add(new Point(lineStates.get(i - 1).isNowPoint()));
        }
        return lineStates;
    }

    boolean isMatchLineState(int i) {
        return this.lineStates.get(i).isNowPoint();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Point point : lineStates) {
            stringBuilder.append(point.toString());
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine line = (LadderLine) o;
        return playerCount == line.playerCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerCount);
    }
}
