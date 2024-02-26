package ladder.model;

import ladder.dto.LineDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private static final Random random = new Random();
    private final List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(LadderSize ladderSize) {
        int height = ladderSize.height();
        int width = ladderSize.width();

        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladder.add(new Line(makeRandomRow(width)));
        }

        return new Ladder(ladder);
    }

    private static List<LadderPath> makeRandomRow(int width) {
        List<LadderPath> randomPath = new ArrayList<>(generatePairableRandomPath(width));

        if (randomPath.size() < width) {
            randomPath.add(LadderPath.STAY);
        }

        return randomPath;
    }

    private static List<LadderPath> generatePairableRandomPath(int maxWidth) {
        List<LadderPath> randomPathWithPair = new ArrayList<>();

        while (randomPathWithPair.size() < maxWidth - 1) {
            randomPathWithPair.addAll(generateRandomPath());
        }

        return randomPathWithPair;
    }

    private static List<LadderPath> generateRandomPath() {
        boolean isConnectedPath = random.nextBoolean();

        if (isConnectedPath) {
            return List.of(LadderPath.RIGHT, LadderPath.LEFT);
        }
        return List.of(LadderPath.STAY);
    }

    public LadderSize getSize() {
        return new LadderSize(ladder.size(), ladder.get(0).size());
    }

    public List<LineDto> toLineDtoList() {
        return ladder.stream()
                .map(LineDto::from)
                .toList();
    }
}
