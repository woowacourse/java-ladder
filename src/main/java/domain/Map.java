package domain;

import exception.InvalidLadderCountException;
import exception.NotNumberException;
import java.util.ArrayList;
import java.util.List;

public class Map {

    private final int height;
    private final List<Ladder> ladders = new ArrayList<>();

    public Map(String height, int ladderCount) {
        validate(height, ladderCount);
        this.height = Integer.parseInt(height);
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

}
