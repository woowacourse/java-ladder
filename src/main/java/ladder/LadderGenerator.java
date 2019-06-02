package ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {
    public static Ladder generate(ParticipantGroup participantGroup, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(LineGenerator.generate(participantGroup));
        }
        return new Ladder(lines);
    }
}
