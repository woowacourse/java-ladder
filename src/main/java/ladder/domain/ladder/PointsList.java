package ladder.domain.ladder;

import ladder.domain.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PointsList {
    private static final boolean endPoint = false;

    private List<PointCopy> createPointList(int countOfPlayer, RandomBooleanGenerator randomBooleanGenerator) {
        List<PointCopy> pointList = new ArrayList<>();

        IntStream.range(0, countOfPlayer)
                .forEach(current -> {
                    boolean right = randomBooleanGenerator.generate();

                    if (current == 0) {
                        pointList.add(createStartPoint(right));
                    }

                    if (current == countOfPlayer - 1) { // 끝인 경우
                        createEndPoint(pointList.get(current - 1));
                    }

                    createNextPoint(pointList.get(current - 1), right);
                });

        return pointList;
    }

    private PointCopy createStartPoint(boolean right) {
        return new PointCopy(endPoint, right);
    }

    private PointCopy createEndPoint(PointCopy before) {
        return before.last();
    }

    private PointCopy createNextPoint(PointCopy point, boolean right) {
        if (point.isRightTrue()) { //오른쪽이 true면
            return point.next(false);
        }
        return point.next(right);
    }

}
