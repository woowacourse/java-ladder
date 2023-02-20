package domain.ladder;

import domain.value.Height;
import domain.value.Width;

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

    public Ladder createLadder(final Width width, final Height height) {
        List<Line> lines = IntStream.range(0, height.value())
                .mapToObj(it -> createLine(width, scaffoldGenerator))
                .collect(Collectors.toUnmodifiableList());
        return new Ladder(lines);
    }

    private Line createLine(final Width width, final ScaffoldGenerator scaffoldGenerator) {
        Deque<Scaffold> scaffolds = new ArrayDeque<>();
        IntStream.range(0, width.value()).forEach(it -> createNonConsistScaffold(scaffolds, scaffoldGenerator));
        return new Line(new ArrayList<>(scaffolds));
    }

    private void createNonConsistScaffold(final Deque<Scaffold> scaffolds, final ScaffoldGenerator scaffoldGenerator) {
        Scaffold scaffold = scaffoldGenerator.generate();
        if (scaffold == Scaffold.EXIST && scaffolds.peekLast() == Scaffold.EXIST) {
            scaffolds.add(Scaffold.NONE);
            return;
        }
        scaffolds.add(scaffold);
    }
}
