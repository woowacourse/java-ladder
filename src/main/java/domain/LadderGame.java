package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
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
            lines.add(new Line());
        }

        return new Lines(lines);
    }
}
