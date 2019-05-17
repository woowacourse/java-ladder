package ladderGame.model.ladder;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderFactory {
    private final LadderRowFactory rowFactory;

    public LadderFactory(LadderRowFactory rowFactory) {
        this.rowFactory = rowFactory;
    }

    public Ladder newInstance(int rows, int columns) {
        return new Ladder(Stream.generate(() -> rowFactory.newInstance(columns))
                .limit(rows).collect(Collectors.toList()));
    }
}
