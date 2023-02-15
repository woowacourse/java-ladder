package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

//
//import java.util.ArrayList;
//import java.util.List;
//
public class LineCreator {

    private final BooleanGenerator booleanGenerator;

    public LineCreator(BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public List<Line> createLines(int width, int height) {
        List<Line> lines = new ArrayList<>();
        LineCreator lineCreator = new LineCreator(booleanGenerator);
        for (int i = 0; i < height; i++) {

            Line line = lineCreator.create(booleanGenerator, width);
            lines.add(line);
        }
        return lines;
    }

    //
    public Line create(int participantsSize) {
//        while (true) {
//            try {
//                return createLine(booleanGenerator, participantsSize);
//            } catch (IllegalArgumentException ignored) {
//                /* ignored */
//            }
//        }
    }
//
//    private static Line createLine(BooleanGenerator booleanGenerator, int participantsSize) {
//        List<Boolean> points = new ArrayList<>();
//        for (int count = 0; count < participantsSize; count++) {
//            points.add(booleanGenerator.generate());
//        }
//        return new Line(points);
//    }
//
}
