package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LadderFactory {

    private final ScaffoldGenerator scaffoldGenerator;

    public LadderFactory(final ScaffoldGenerator scaffoldGenerator) {
        this.scaffoldGenerator = scaffoldGenerator;
    }

    public Ladder createLadder(final int width, final int height) {
        List<Line> lines = new ArrayList<>();
        insertLines(width, height, lines);
        return new Ladder(lines);
    }

    private void insertLines(int width, int height, List<Line> lines) {
        for (int i = 0; i < height; i++) {
            List<Scaffold> scaffolds = insertScaffold(width);
            lines.add(new Line(scaffolds));
        }
    }

    private List<Scaffold> insertScaffold(int width) {
        List<Scaffold> scaffolds = new ArrayList<>();
        generateScaffold(width, scaffolds);
        return scaffolds;
    }

    private void generateScaffold(int width, List<Scaffold> scaffolds) {
        IntStream.range(0, width).forEach(value -> {
            createConsecutiveScaffold(scaffolds, value);
        });
    }

    private void createConsecutiveScaffold(List<Scaffold> scaffolds, int value) {
        Scaffold scaffold = scaffoldGenerator.generate();
        if (scaffolds.isEmpty()) {
            scaffolds.add(scaffold);
            return;
        }
        scaffold = validateConsecutiveScaffold(scaffolds, value, scaffold);
        scaffolds.add(scaffold);
    }

    private static Scaffold validateConsecutiveScaffold(List<Scaffold> scaffolds, int j, Scaffold scaffold) {
        if (scaffold == Scaffold.EXIST && scaffolds.get(j - 1) == Scaffold.EXIST) {
            scaffold = Scaffold.NONE;
        }
        return scaffold;
    }
}
