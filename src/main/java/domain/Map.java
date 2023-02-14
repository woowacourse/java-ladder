package domain;

import exception.InvalidLadderCountException;
import exception.NotNumberException;
import java.util.ArrayList;
import java.util.List;
import util.BooleanGenerator;

public class Map {

    private final int height;
    private final int ladderCount;

    public List<Ladder> getLadders() {
        return ladders;
    }

    private final List<Ladder> ladders = new ArrayList<>();

    public Map(String height, int ladderCount) {
        validate(height, ladderCount);
        this.height = Integer.parseInt(height);
        this.ladderCount = ladderCount;
    }

    private void validate(String height, int ladderCount) {
        if (!isNum(height)) {
            throw new NotNumberException();
        }
        if (!isValidLadderCount(ladderCount)) {
            throw new InvalidLadderCountException();
        }
    }

    private boolean isNum(String height) {
        return !(height == null || height.isBlank() || !height.matches("^[1-9]*$"));
    }

    private boolean isValidLadderCount(int ladderCount) {
        final int minLadderCount = 1;
        final int maxLadderCount = 9;
        return !(ladderCount < minLadderCount || ladderCount > maxLadderCount);
    }

    public void generate(BooleanGenerator booleanGenerator) {
        List<Integer> avoid = new ArrayList<>();
        for (int count = 0; count < ladderCount; count++) {
            Ladder ladder = new Ladder(height);
            ladder.generate(avoid, booleanGenerator);
            ladders.add(ladder);
            avoid = ladders.get(ladders.size() - 1).getConnectedIndex();
        }
    }
}
