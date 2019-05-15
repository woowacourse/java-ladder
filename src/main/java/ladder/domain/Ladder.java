package ladder.domain;

import ladder.Const;
import ladder.util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private List<Player> players;
    private final int depth;
    private List<LadderLine> ladderlines;

    public Ladder(String name) {
        this(name, Const.MIN_LINE_COUNT);
    }

    public Ladder(String name, int depth) {
        this.players = regePlayers(name.replaceAll(" ", ""));
        this.depth = checkDepth(depth);
        this.ladderlines = setLadderLines();
    }

    private List<Player> regePlayers(String name) {
        List<String> names = checkNames(name);
        List<Player> players = new ArrayList<>();
        for (String s : names) {
            players.add(new Player(s));
        }
        return players;
    }

    private List<String> checkNames(String name) {
        List<String> names = Arrays.asList(name.split(","));
        if (names.size() <= Const.ZERO) {
            throw new IllegalArgumentException(Const.EX_NAME);
        }
        return names;
    }

    private int checkDepth(int depth) {
        if (depth < Const.MIN_LINE_COUNT) {
            throw new IllegalArgumentException(Const.EX_LINE_COUNT);
        }
        return depth;
    }

    private List<LadderLine> setLadderLines() {
        List<LadderLine> ladderLines = new ArrayList<>();
        for (int i = 0; i < depth; i++) {
            ladderLines.add(new LadderLine(players.size()));
        }
        return ladderLines;
    }

    public String getResultLadderLines() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LadderLine line : ladderlines) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

    public String getResultLadderNames() {
        List<String> names = getNames();
        StringBuilder stringBuilder = new StringBuilder();
        for (String name : names) {
            stringBuilder.append(name);
        }
        return stringBuilder.toString();
    }

    private List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (Player player : players) {
            names.add(Util.formatName(player.getName()));
        }
        return names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return depth == ladder.depth &&
                Objects.equals(players, ladder.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players, depth);
    }
}
