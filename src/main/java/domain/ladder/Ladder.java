package domain.ladder;

import domain.player.Player;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Ladder {
    private final List<Paths> paths;

    private Ladder(final List<Paths> paths) {
        this.paths = paths;
    }

    public static Ladder of(final Supplier<Boolean> randomGenerator, final LadderHeight ladderHeight, final int playersCount) {
        return IntStream.rangeClosed(1, ladderHeight.value())
                .mapToObj(floor -> Paths.init(randomGenerator, playersCount - 1))
                .collect(collectingAndThen(toList(), Ladder::new));
    }

    public List<Paths> getPaths() {
        return unmodifiableList(paths);
    }

    public void movePlayer(final Player player) {
        player.move(getMovingIndex(player.getCurrentLineNumber(), player.getCurrentLineFloor()));
    }

    private int getMovingIndex(final LineNumber lineNumber, final LineFloor lineFloor) {
        return paths.get(lineFloor.value() - 1)
                .getOtherLineNumber(lineNumber);
    }
}
