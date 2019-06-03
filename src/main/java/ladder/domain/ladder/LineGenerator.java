package ladder.domain.ladder;

import ladder.domain.participant.ParticipantGroup;
import ladder.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {
    public static Line generate(ParticipantGroup participantGroup) {
        List<Direction> directions = new ArrayList<>();
        int size = participantGroup.getSize();

        directions.add(Direction.first(RandomGenerator.generateBoolean()));
        for (int i = 0; i < size - 2; i++) {
            directions.add(directions.get(i).next(RandomGenerator.generateBoolean()));
        }
        directions.add((directions.get(size - 2).last()));

        return new Line(directions);
    }
}
