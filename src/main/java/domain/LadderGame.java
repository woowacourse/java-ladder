package domain;

import java.util.ArrayList;
import java.util.List;
import util.RandomBooleanGenerator;
import util.RandomValueGenerator;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class LadderGame {

    public Person createPerson(List<String> names) {
        List<People> person = new ArrayList<>();
        for (String name : names) {
            person.add(new People(name));
        }
        return new Person(person);
    }

    public Lines createLines(int width, int height) {
        RandomValueGenerator generator = new RandomBooleanGenerator();
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.newInstanceWithPersonCount(width, generator));
        }
        return new Lines(lines);
    }

}
