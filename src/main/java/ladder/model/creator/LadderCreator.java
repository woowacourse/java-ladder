package ladder.model.creator;

import ladder.model.ladder.Floor;
import ladder.model.ladder.Ladder;
import ladder.model.ladder.Line;

import java.util.ArrayList;
import java.util.List;

public class LadderCreator {

        public static Ladder create(Floor floor, int tagNumber) {
                List<Line> lines = new ArrayList<>();
                for (int index = 0; index < floor.getNumber(); index++) {
                        lines.add(new Line(LineCreator.create(tagNumber)));
                }
                return new Ladder(lines);
        }
}
