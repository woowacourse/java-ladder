package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private static final int MAX_HEIGHT_RATIO = 2;

    private final List<Line> lines;

    public Ladder(List<Line> lines, int playerCount) {
        validatePlayersCount(lines.size(), playerCount);
        this.lines = lines;
    }

    private void validatePlayersCount(int height, int playersCount) {
        if (isProperRange(height, playersCount)) {
            throw new IllegalArgumentException("[ERROR] 사다리의 높이는 사람 수보다 크거나, 사람 수의 두 배 보다 작아야 합니다.");
        }
    }

    private static boolean isProperRange(int height, int playersCount) {
        return playersCount * MAX_HEIGHT_RATIO < height || height < playersCount;
    }

    public Line findLineByIndex(int index) {
        if (isProperIndex(index)) {
            throw new IllegalArgumentException("[ERROR] 인덱스 범위를 초과했습니다.");
        }
        return lines.get(index);
    }

    private boolean isProperIndex(int index) {
        return index < 0 || index >= lines.size();
    }

    public int getLadderIndexResult(int index) {
        return getLadderIndexResult(0, index);
    }

    private int getLadderIndexResult(int height, int index) {
        if (height >= lines.size()) {
            return index;
        }
        Line line = findLineByIndex(height);
        List<Step> steps = line.getSteps();
        if (index <= 0) { // 왼쪽에 스탭이 없을 때
            if (steps.get(index) == Step.EXIST) { // 오른쪽에 스탭이 있으면
                return getLadderIndexResult(height + 1, index + 1); // 오른쪽 밑으로
            }
            return getLadderIndexResult(height + 1, index); // 스탭이 없다면 밑으로
        }
        if (index >= steps.size()) { // 오른쪽에 스탭이 없을 때
            if (steps.get(index - 1) == Step.EXIST) { // 왼쪽에 스탭이 있으면
                return getLadderIndexResult(height + 1, index - 1); // 왼쪽 밑으로
            }
            return getLadderIndexResult(height + 1, index); // 스탭이 없다면 밑으로
        }
        if (steps.get(index) == Step.EXIST) { // 오른쪽에 스탭이 있을 때
            return getLadderIndexResult(height + 1, index + 1);
        }
        if (steps.get(index - 1) == Step.EXIST) {
            return getLadderIndexResult(height + 1, index - 1);
        }
        return getLadderIndexResult(height + 1, index); // 밑으로
    }

    public int getHeight() {
        return lines.size();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
