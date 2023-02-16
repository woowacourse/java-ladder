package helper;

import domain.Bridge;
import domain.Line;
import domain.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractTestFixture {

    public List<Bridge> convert(Boolean... flags) {
        return Arrays.stream(flags)
                     .map((flag) -> {
                         if (flag) {
                             return Bridge.EXIST;
                         }
                         return Bridge.EMPTY;
                     })
                     .collect(Collectors.toList());
    }

    public List<Person> createDefaultPerson() {
        return List.of(new Person("aa"));
    }

    public List<Line> createLines(final int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(convert(true, false, true)));
        }
        return lines;
    }
}
