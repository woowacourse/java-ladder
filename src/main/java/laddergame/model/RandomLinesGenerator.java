package laddergame.model;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLinesGenerator {
    private final Random random = new Random();

    public LadderGame getLadderGame(LadderHeight ladderHeight, Participants participants) {
        List<List<Boolean>> booleans = generateBooleans(ladderHeight.getHeight(), participants.getSize());
        return booleans.stream()
                .map(LineGenerator::new)
                .map(LineGenerator::generate)
                .collect(collectingAndThen(toList(), LadderGame::new));
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
