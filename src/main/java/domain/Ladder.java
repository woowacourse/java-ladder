package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladder {

    private final Height height;
    private final List<Line> lines;

    private Ladder(Height height, List<Line> lines) {
        this.height = height;
        this.lines = lines;
    }

    public static Ladder createLadderWithLines(LegGenerateStrategy legGenerateStrategy, Height height, int width) {
        return new Ladder(height, makeLines(legGenerateStrategy, height.getHeight(), width));
    }

    private static List<Line> makeLines(LegGenerateStrategy legGenerateStrategy, int height, int width) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Line line = Line.createLineWithLegs(legGenerateStrategy, width);
            lines.add(line);
        }
        return lines;
    }

    public String findPlayerReward(int playerOrderNumber, Rewards rewards) {
        int index = playerOrderNumber;
        for (int i = 0; i < height.getHeight(); i++) {
            Line presentLine = lines.get(i);
            index = presentLine.findNextIndex(index);
        }
        return rewards.getRewardByIndex(index);
    }

    public Map<Player, String> findAllPlayerReward(Players players, Rewards rewards) {
        Map<Player, String> allPlayerResult = new HashMap<>();
        for (Player player : players.getPlayers()) {
            int playerIndex = players.getPlayerOrderNumber(player.getName());
            allPlayerResult.put(player, findPlayerReward(playerIndex, rewards));
        }
        return allPlayerResult;
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
