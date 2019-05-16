package ladder.domain;

import ladder.util.Const;
import ladder.util.Rule;
import ladder.util.Util;

import java.util.*;

public class Ladder {
    private List<Player> players;
    private final List<String> reward;
    private final int depth;
    private List<LadderLine> ladderLines;
    private Map<String, String> result;

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
        List<String> rewards = Arrays.asList(Rule.ruleInputReward(reward, players.size()).split(","));
        return rewards;
    }

    private List<Player> regePlayers(String name) {
        List<Player> players = new ArrayList<>();
        List<String> names = Arrays.asList(Rule.ruleInputPlayerNames(name).split(","));
        for (int i = 0; i < names.size(); i++) {
            players.add(new Player(names.get(i), i));
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
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (LadderLine line : ladderLines) {
            stringJoiner.add(line.toString());
        }
        return stringJoiner.toString();
    }

    public String getResultLadderNames() {
        List<String> names = getNames();
        StringBuilder stringBuilder = new StringBuilder();
        for (String name : names) {
            stringBuilder.append(name);
        }
        return stringBuilder.toString();
    }

    public String getResultLadderRewards() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : reward) {
            stringBuilder.append(Util.formatAlignLeft(s));
        }
        return stringBuilder.toString();
    }

    public String getResultLadderRewards(String name) {
        if (name.equals("all")) {
            return getResultAllRewards();
        }
        return result.get(name);
    }

    private String getResultAllRewards() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (Map.Entry<String, String> stringStringEntry : result.entrySet()) {
            stringJoiner.add(stringStringEntry.getKey() + " : " + stringStringEntry.getValue());
        }
        return stringJoiner.toString();
    }

    public void playRadder() {
        for (int i = 0; i < depth; i++) {
            moveRadderLIne(i);
        }
        result = setLadderResult();
    }

    private Map<String, String> setLadderResult() {
        Map<String, String> result = new LinkedHashMap<>();
        for (Player player : players) {
            result.put(player.getName(),reward.get(player.getPosition()));
        }
        return result;
    }

    private void moveRadderLIne(int depth) {
        for (Player player : players) {
            if (ladderLines.get(depth).getNextPosition(player.getPosition()) > Const.ZERO) {
                player.moveRightPosition();
                continue;
            }
            if (ladderLines.get(depth).getNextPosition(player.getPosition()) < Const.ZERO) {
                player.moveLeftPosition();
                continue;
            }
        }
    }

    public int getPlayerPosition(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player.getPosition();
            }
        }
        throw new IllegalArgumentException("값이 잘못되었습니다.");
    }

    private List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (Player player : players) {
            names.add(Util.formatAlignRight(player.getName()));
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
