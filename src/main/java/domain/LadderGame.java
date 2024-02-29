package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.Generator;
import util.LadderBuilder;
import util.RandomGenerator;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;
    private final Winnings winnings;
    private final Generator generator;

    public LadderGame(Players players, Height height, Winnings winnings) {
        this.ladder = new Ladder(height);
        this.players = players;
        this.generator = new RandomGenerator();
        this.winnings = winnings;
        this.ladder.init(players.getPlayersNumber(), this.generator);
    }

    LadderGame(Players players, Height height, Winnings winnings, Generator generator) {
        this.ladder = new Ladder(height);
        this.players = players;
        this.generator = generator;
        this.winnings = winnings;
        this.ladder.init(players.getPlayersNumber(), this.generator);
    }

    public List<String> getLadderShape() {
        return LadderBuilder.getLadder(players, ladder, winnings);
    }

    public List<Name> getClimbedNames() {
        List<Name> names = players.getPlayers();
        for (Line line : ladder.getLadder()) {
            climb(line, names);
        }
        return names;
    }

    public Map<Name, Winning> getResult() {
        Map<Name, Winning> results = new HashMap<>();
        List<Name> names = getClimbedNames();
        List<Winning> winning = winnings.getWinnings();
        for (int index = 0; index < players.getPlayersNumber(); index++) {
            results.put(names.get(index), winning.get(index));
        }
        return results;
    }

    private void climb(Line line, List<Name> names) {
        List<Integer> indices = line.getConnectedIndex();
        for (int index : indices) {
            Collections.swap(names, index, index - 1);
        }
    }
}
