package ladder.domain;

import ladder.util.BooleanListGenerator;
import ladder.util.RandomBooleanListGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();


    public Ladder(Height height, People people) {
        BooleanListGenerator booleanListGenerator = new RandomBooleanListGenerator();

        while (!height.isSame(getLinesSize())) {
            lines.add(new Line(people.count(), booleanListGenerator));
        }
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(lines);
    }
}
