package laddergame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLinesGenerator {
    private final Random random = new Random();

    public List<Line> getLines(LadderHeight ladderHeight, Participants participants) {
        List<List<Boolean>> generatedBooleans =
                generateBooleans(ladderHeight.getHeight(), participants.getSize());
        return generatedBooleans.stream()
                .map(Line::new)
                .toList();
    }

    private List<List<Boolean>> generateBooleans(int row, int col) {
        List<List<Boolean>> booleans = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            booleans.add(createBoolean(col));
        }
        return booleans;
    }

    private List<Boolean> createBoolean(int count) {
        List<Boolean> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            results.add(random.nextBoolean());
        }
        return results;
    }
}
