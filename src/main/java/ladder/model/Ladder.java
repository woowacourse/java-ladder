package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<LadderWidth> lines;
    private int width;

    public Ladder(LadderGamePlayers players, int height, int width) {
        this.lines = new ArrayList<>();
        this.lines = makeLadder(players, height);
        this.width = width;
    }

    public List<LadderWidth> getLines() {
        return lines;
    }

    public int getWidth() {
        return width;
    }

    private List<LadderWidth> makeLadder(LadderGamePlayers players, int height) {
        for (int i = 0; i < height; i++) {
            lines.add(new LadderWidth(players.size() - 1));
        }
        return lines;
    }

    List<LadderPlayer> changePlayer(List<LadderPlayer> players) {
        for (LadderWidth line : lines) {
            players = line.changePlayer(players);
        }
        return players;
    }

}
