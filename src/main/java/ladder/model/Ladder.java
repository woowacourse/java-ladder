package ladder.model;

import ladder.constant.LadderPath;
import ladder.dto.LineDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private static final Random random = new Random();
    private final List<Line> ladder;

    public Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(LadderSize ladderSize) {
        List<Line> ladder = new ArrayList<>();

        int height = ladderSize.getHeight();
        int width = ladderSize.getWidth();

        for (int i = 0; i < height; i++) {
            Line line = new Line(makeRandomPaths(width));
            ladder.add(line);
        }

        return new Ladder(ladder);
    }

    private static List<LadderPath> makeRandomPaths(int width) {
        List<LadderPath> randomPath = new ArrayList<>();

        while (randomPath.size() < width - 1) {
            LadderPath temp = generateRandomPath();
            randomPath.add(temp);
            if (temp.equals(LadderPath.RIGHT)) {
                randomPath.add(LadderPath.LEFT);
            }
        }

        if (randomPath.size() < width) {
            randomPath.add(LadderPath.STAY);
        }

        return randomPath;
    }

    private static LadderPath generateRandomPath() {
        if (random.nextBoolean()) {
            return LadderPath.RIGHT;
        }
        return LadderPath.STAY;
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
