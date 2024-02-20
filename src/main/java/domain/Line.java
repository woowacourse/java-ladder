package domain;

import java.util.*;
import java.util.stream.IntStream;

public class Line {

    List<Boolean> points = new ArrayList<>();

    public Line() {
    }

    public Line(List<Boolean> points) {
        for(int i=1; i< points.size(); i++){
            if (points.get(i - 1).equals(points.get(i)) && points.get(i).equals(true)) {
                throw new IllegalArgumentException("가로 길이는 겹칠 수 없습니다.");
            }
        }
    }

    public Line(int personCount) {
        for (int i = 0; i < personCount-1; i++) {
            points.add(false);
        }
    }

    public List<Boolean> generateRandomPoint(Generator generator) {
        points = points.stream().map(r -> generator.generate()).toList();
        return points;
    }
}
