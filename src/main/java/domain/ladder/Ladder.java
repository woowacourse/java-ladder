package domain.ladder;

import domain.*;
import domain.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static java.util.Collections.unmodifiableList;

public class Ladder {
    private final List<Paths> paths;

    private Ladder(final List<Paths> paths) {
        this.paths = paths;
    }

    public static Ladder of(Supplier<Boolean> randomGenerator, LadderHeight ladderHeight, int playersCount) {
        List<Paths> paths = new ArrayList<>();
        for (int floor = 1; floor <= ladderHeight.ladderHeight(); floor++) {
            paths.add(Paths.init(randomGenerator, playersCount - 1));
        }

        return new Ladder(paths);
    }

    public List<Paths> getPaths() {
        return unmodifiableList(paths);
    }

    public void movePlayer(Player player) {
        LineNumber currentLineNumber = player.getCurrentLineNumber();
        LineFloor currentLineFloor = player.getCurrentLineFloor();
        player.move(getMovingIndex(currentLineNumber, currentLineFloor));
    }

    private int getMovingIndex(LineNumber lineNumber, LineFloor lineFloor) {
        return paths.get(lineFloor.value() - 1)
                .getOtherLineNumber(lineNumber);
    }
}
