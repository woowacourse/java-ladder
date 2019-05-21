package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private List<LadderWidth> lines;

    public Ladder(LadderGamePlayers players, int height, int width) {
        this.lines = new ArrayList<>();
        this.lines = makeLadder(players, height, width);
    }

    private List<LadderWidth> makeLadder(LadderGamePlayers players, int height, int width) {
        for (int i = 0; i < height; i++) {
            lines.add(new LadderWidth(players.size() - 1, width));
        }
        return lines;
    }

    List<LadderPlayer> changePlayer(List<LadderPlayer> players) {
        for (LadderWidth line : lines) {
            players = line.changePlayer(players);
        }
        return players;
    }

    @Override
    public String toString() {
        return lines.stream().map(LadderWidth::toString).collect(Collectors.joining("\n"));
    }
}
