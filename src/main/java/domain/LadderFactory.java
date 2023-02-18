package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LadderFactory {

    private final ScaffoldGenerator scaffoldGenerator;

    public LadderFactory(final ScaffoldGenerator scaffoldGenerator) {
        this.scaffoldGenerator = scaffoldGenerator;
    }


    public Ladder createLadder(final Width width, final Height height) {
        List<Line> lines = generateLines(width, height);
        return new Ladder(lines);
    }

    private List<Line> generateLines(Width width, Height height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            List<Scaffold> scaffolds = generateScaffolds(width);
            lines.add(new Line(scaffolds));
        }
        return lines;
    }

    private List<Scaffold> generateScaffolds(Width width) {
        List<Scaffold> scaffolds = new ArrayList<>();
        IntStream.range(0, width.getValue()).forEach(index -> {
            insertDiscontinuousScaffold(scaffolds, index);
        });
        return scaffolds;
    }

    private void insertDiscontinuousScaffold(List<Scaffold> scaffolds, int index) {
        Scaffold scaffold = scaffoldGenerator.generate();
        if (scaffolds.isEmpty()) {
            scaffolds.add(scaffold);
            return;
        }
        scaffold = generateDiscontinuousScaffold(scaffolds, index, scaffold);
        scaffolds.add(scaffold);
    }

    private static Scaffold generateDiscontinuousScaffold(List<Scaffold> scaffolds, int scaffoldIndex, Scaffold scaffold) {
        if (scaffold == Scaffold.EXIST && scaffolds.get(scaffoldIndex - 1) == Scaffold.EXIST) {
            scaffold = Scaffold.NONE;
        }
        return scaffold;
    }
}
