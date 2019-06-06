package ladder.domain.ladder;

import ladder.domain.participant.ParticipantGroup;

public class LineGenerator {
    public static Line generate(ParticipantGroup participantGroup) {
        return new Line(DirectionGenerator.generate(participantGroup));
    }
}
