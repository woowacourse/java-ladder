package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    public Peoples createPeoples(List<String> names) {
        List<People> peoples = new ArrayList<>();
        for (String name : names) {
            peoples.add(new People(name));
        }
        return new Peoples(peoples);
    }

    public Lines createLines(int width, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(width));
        }
        return new Lines(lines);
    }

}
