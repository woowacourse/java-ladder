package model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<LadderRow> ladder;

    public Ladder(Height height, LadderRowGenerator generator, Participants participants) {
        List<LadderRow> rows = new ArrayList<>();
        for (int i = 0; i < height.value(); i++) {
            LadderRow ladderRow = createLadderRow(generator, participants);
            rows.add(ladderRow);
        }
        this.ladder = rows;
    }

    Ladder(List<LadderRow> ladderRows) {
        this.ladder = ladderRows;
    }

    private LadderRow createLadderRow(LadderRowGenerator generator, Participants participants) {
        List<Boolean> rows = new ArrayList<>();
        rows.add(generator.generate(false));
        for (int i = 0; i < participants.getParticipantsSize() - 2; i++) {
            boolean generated = generator.generate(rows.get(i));
            rows.add(generated);
        }
        return new LadderRow(rows);
    }

    public int getHeight() {
        return ladder.size();
    }

    public LadderRow getRow(int index) {
        return ladder.get(index);
    }

    public int getLadderRowSize() {
        return ladder.get(0).getLinesSize();
    }

    public int moveAll(int participantIndex) {
        return 0;
    }
}
