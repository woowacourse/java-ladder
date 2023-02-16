package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LadderFactory {

    private final ScaffoldGenerator scaffoldGenerator;

    public LadderFactory(final ScaffoldGenerator scaffoldGenerator) {
        this.scaffoldGenerator = scaffoldGenerator;
    }

    public Ladder createLadder(final int width, final Height height) {
        List<Line> lines = generateLines(width, height);
        return new Ladder(lines);
    }

    private List<Line> generateLines(int width, Height height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            List<Scaffold> scaffolds = insertScaffolds(width);
            lines.add(new Line(scaffolds));
        }
        return lines;
    }

    private List<Scaffold> insertScaffolds(int width) {
        List<Scaffold> scaffolds = generateScaffolds(width);
        return scaffolds;
    }

    private List<Scaffold> generateScaffolds(int width) {
        List<Scaffold> scaffolds = new ArrayList<>();
        IntStream.range(0, width).forEach(value -> {
            insertDiscontinuousScaffold(scaffolds, value);
        });
        return scaffolds;
    }

    private void insertDiscontinuousScaffold(List<Scaffold> scaffolds, int value) {
        Scaffold scaffold = scaffoldGenerator.generate();
        if (scaffolds.isEmpty()) {
            scaffolds.add(scaffold);
            return;
        }
        scaffold = generateDiscontinuousScaffold(scaffolds, value, scaffold);
        scaffolds.add(scaffold);
    }

    private static Scaffold generateDiscontinuousScaffold(List<Scaffold> scaffolds, int j, Scaffold scaffold) {
        if (scaffold == Scaffold.EXIST && scaffolds.get(j - 1) == Scaffold.EXIST) {
            scaffold = Scaffold.NONE;
        }
        return scaffold;
    }
}
