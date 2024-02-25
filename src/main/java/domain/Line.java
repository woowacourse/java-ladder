package domain;

import util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<LadderItem> points;
    private final int columnLength;

    public Line(int columnLength) {
        this.points = new ArrayList<>();
        this.columnLength = columnLength;
    }

    public List<LadderItem> makeLine(BooleanGenerator booleanGenerator) {
        // 0번째 point는 이전 point의 영향을 받지 않으므로 미리 추가
        points.add(makeRandomLadderItem(booleanGenerator));

        for (int position = 1; position < columnLength - 1; position++) {
            LadderItem isConnectable = makeRandomLadderItem(booleanGenerator);

            points.add(decideConnectable(position, isConnectable));
        }

        return points;
    }

    private LadderItem makeRandomLadderItem(BooleanGenerator booleanGenerator) {
        return LadderItem.getLadderItemByIsConnected(booleanGenerator.generate());
    }

    private LadderItem decideConnectable(int position, LadderItem isConnectable) {
        if (points.get(position - 1).equals(LadderItem.UNCONNECTED)) {
            return isConnectable;
        }

        return LadderItem.UNCONNECTED;
    }

    public int decideNextPosition(int position) {
        if ((position == columnLength || position - 1 >= 0) && points.get(position -1).equals(LadderItem.CONNECTED)) {
            return position - 1;
        }

        if ((position == 0 || position < columnLength - 1) && points.get(position).equals(LadderItem.CONNECTED)) {
            return position + 1;
        }

        return position;
    }

    public List<LadderItem> getPoints() {
        return points;
    }
}
