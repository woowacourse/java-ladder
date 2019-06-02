package ladder;

import java.util.List;

public class LadderGame {
    private final ParticipantGroup participantGroup;
    private final Ladder ladder;

    public LadderGame(ParticipantGroup participantGroup, Ladder ladder) {
        this.participantGroup = participantGroup;
        this.ladder = ladder;
    }

    public void play() {
        List<Line> lines = ladder.getLines();
        for (int i = 0; i < lines.size(); i++) {
            participantGroup.move(lines.get(i).getDirections());
            System.out.println();
        }
    }
}
