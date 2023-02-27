package domain;

import java.util.ArrayList;
import java.util.List;
import util.RandomValueGenerator;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class Line {

    private static final int WALL_AND_PEOPLE_DIFFERENCE = 1;
    private final List<ConnectStatus> points = new ArrayList<>();
    private Line() {
    }

    public List<ConnectStatus> getPoints() {
        return points;
    }

    public static Line newInstanceWithPersonCount(int personCount, RandomValueGenerator generator){
        Line line = new Line();
        List<ConnectStatus> lineValue = line.points;
        lineValue.add(ConnectStatus.valueOf(generator.generate()));
        --personCount;
        for (int i = 0; i < personCount - WALL_AND_PEOPLE_DIFFERENCE; i++) {
            addLine(lineValue, generator);
        }
        return line;
    }

    private static void addLine(List<ConnectStatus> line, RandomValueGenerator generator) {
        int lastPosition = line.size() - 1;
        if (!line.get(lastPosition).status()) {
            line.add(ConnectStatus.valueOf(generator.generate()));
            return;
        }
        line.add(ConnectStatus.DISCONNECT);
    }
}
