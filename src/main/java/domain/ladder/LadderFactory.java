package domain.ladder;

import domain.value.Height;
import domain.value.Width;

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
                .mapToObj(it -> Line.create(width, scaffoldGenerator))
                .collect(Collectors.toUnmodifiableList());
        return new Ladder(lines);
    }
}
