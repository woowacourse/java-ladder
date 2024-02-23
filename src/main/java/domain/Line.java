package domain;

import util.LadderItemGenerator;
import view.LadderItem;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<LadderItem> points;
    private final int columnLength;

    public Line(int columnLength) {
        this.points = new ArrayList<>();
        this.columnLength = columnLength;
    }

    public List<LadderItem> makeLine(LadderItemGenerator ladderItemGenerator) {
        // 0번째 point는 이전 point의 영향을 받지 않으므로 미리 추가
        points.add(ladderItemGenerator.generate());

        for (int position = 1; position < columnLength - 1; position++) {
            LadderItem isConnectable = ladderItemGenerator.generate();

            points.add(decideConnectable(position, isConnectable));
        }

        return points;
    }

    private LadderItem decideConnectable(int position, LadderItem isConnectable) {
        if (points.get(position - 1).equals(LadderItem.UNCONNECTED)) {
            return isConnectable;
        }

        return LadderItem.UNCONNECTED;
    }

    public List<LadderItem> getPoints() {
        return points;
    }
}
