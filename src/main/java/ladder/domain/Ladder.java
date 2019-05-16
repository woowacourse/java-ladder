package ladder.domain;

import ladder.util.Const;
import ladder.util.Rule;
import ladder.util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private List<Player> players;
    private final List<String> reward;
    private final int depth;
    private List<LadderLine> ladderLines;

    public Ladder(String name) {
        this(name, Const.MIN_LINE_COUNT);
    }

    public Ladder(String name, int depth) {
        this(name, name, depth);
    }

    public Ladder(String name, String reward, int depth) {
        this.players = regePlayers(name);
        this.reward = regeReward(reward);
        this.depth = Rule.ruleLadderDepthRange(depth);
        this.ladderLines = setLadderLines();
    }

    private List<String> regeReward(String reward) {
        List<String> rewards = Arrays.asList(Rule.ruleInputReward(reward,players.size()).split(","));
        return rewards;
    }

    private List<Player> regePlayers(String name) {
        List<Player> players = new ArrayList<>();
        List<String> names = Arrays.asList(Rule.ruleInputPlayerNames(name).split(","));
        for (String s : names) {
            players.add(new Player(s));
        }
        return players;
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
        for (LadderLine line : ladderLines) {
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
