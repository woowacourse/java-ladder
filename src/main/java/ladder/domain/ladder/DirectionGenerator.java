package ladder.domain.ladder;

import ladder.domain.participant.ParticipantGroup;
import ladder.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class DirectionGenerator {
    private static final int FIRST_LINE = 0;

    public static List<Direction> generate(ParticipantGroup participantGroup) {
        int size = participantGroup.getSize();
        List<Direction> directions = new ArrayList<>();

        directions.add(Direction.first(RandomGenerator.generateBoolean()));
        for (int i = FIRST_LINE; i < size - 2; i++) {
            directions.add(directions.get(i).next(RandomGenerator.generateBoolean()));
        }
        directions.add((directions.get(size - 2).last()));

        return directions;
    }
}
