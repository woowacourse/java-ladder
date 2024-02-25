package domain;

import java.util.List;
import java.util.stream.IntStream;

public class LadderCreator {

    public Ladder createLadder(RowLineGenerator rowLineGenerator, int personCount, Height height) {
        List<RowLine> lines = IntStream.range(0, height.getHeight())
                .mapToObj(i -> rowLineGenerator.generate(personCount))
                .toList();
        return new Ladder(lines);
    }
}
