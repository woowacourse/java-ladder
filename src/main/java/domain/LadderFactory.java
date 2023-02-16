package domain;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderFactory {

    private final ScaffoldGenerator scaffoldGenerator;

    public LadderFactory(final ScaffoldGenerator scaffoldGenerator) {
        this.scaffoldGenerator = scaffoldGenerator;
    }

    public Ladder createLadder(final int width, final int height) {
        List<Line> lines = IntStream.range(0, height)
                .mapToObj(it -> createLine(width))
                .collect(Collectors.toUnmodifiableList());
        return new Ladder(lines);
    }

    private Line createLine(final int width) {
        return new Line(createScaffolds(width));
    }

    private List<Scaffold> createScaffolds(final int width) {
        Deque<Scaffold> scaffolds = new ArrayDeque<>();
        IntStream.range(0, width).forEach(it -> createScaffold(scaffolds));
        return new ArrayList<>(scaffolds);
    }

    private void createScaffold(final Deque<Scaffold> scaffolds) {
        Scaffold scaffold = scaffoldGenerator.generate();
        if (scaffolds.isEmpty()) {
            scaffolds.add(scaffold);
            return;
        }
        if (scaffold == Scaffold.EXIST && scaffolds.peekLast() == Scaffold.EXIST) {
            scaffolds.add(Scaffold.NONE);
            return;
        }
        scaffolds.add(scaffold);
    }
}
