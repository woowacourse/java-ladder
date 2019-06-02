package ladder;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {
    public static Line generate(ParticipantGroup participantGroup) {
        List<Position> positions = new ArrayList<>();
        int size = participantGroup.getSize();

        positions.add(Position.first(RandomGenerator.generateBoolean()));
        for (int i = 0; i < size - 2; i++) {
            positions.add(positions.get(i).next(i + 1, RandomGenerator.generateBoolean()));
        }
        positions.add((positions.get(size - 2).last(size - 1)));

        return new Line(positions);
    }
}
