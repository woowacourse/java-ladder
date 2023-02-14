package domain;

import exception.InvalidLadderCountException;
import exception.NotNumberException;
import java.util.ArrayList;
import java.util.List;

public class Map {

    private final int height;
    private final List<Ladder> ladders = new ArrayList<>();

    public Map(String height, int ladderCount) {
        final int minLadderCount = 1;
        final int maxLadderCount = 9;

        if (height.isBlank() || height == null || !height.matches("^[1-9]*$")) {
            throw new NotNumberException();
        }
        if (ladderCount < minLadderCount || ladderCount > maxLadderCount) {
            throw new InvalidLadderCountException();
        }
        this.height = Integer.parseInt(height);
    }
}
