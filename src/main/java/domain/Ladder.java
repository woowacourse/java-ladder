package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladder;
    private final BooleanCreator booleanCreator;

    public Ladder(int ladderHeight, Players players, BooleanCreator booleanCreator) {
        this.booleanCreator = booleanCreator;
        this.ladder = createLadder(ladderHeight, players);
    }

    public List<Line> createLadder(int ladderHeight, Players players) {
        List<Line> list = new ArrayList<>();

        for (int i = 0; i < ladderHeight; i++) {
            Line line = createLine(players);
            list.add(line);
        }
        return list;
    }

    private Line createLine(Players players) {
        Block preBlock = new Block(booleanCreator.generate());
        List<Block> blocks = createBlocks(players, preBlock);
        return new Line(players, blocks);
    }

    private List<Block> createBlocks(Players players, Block preBlock) {
        List<Block> blocks = new ArrayList<>(List.of(preBlock));
        for (int i = 1; i < players.getPlayersSize() - 1; i++) {
            Block nextBlock = new Block(booleanCreator.generate());
            nextBlock.comparePreBlock(preBlock);
            blocks.add(nextBlock);
            preBlock = nextBlock;
        }
        return blocks;
    }

    public void getRewardsForPlayers(Players players, Rewards rewards) {
        List<Player> result = players.getPlayers();
        traverseLines(result);
        matchRewardsForPlayers(rewards, result);
    }

    private static void matchRewardsForPlayers(Rewards rewards, List<Player> result) {
        for(Player player : result){
            player.setReward(rewards.getRewards().get(result.indexOf(player)));
        }
    }

    private void traverseLines(List<Player> result) {
        for (Line line : ladder) {
            traverseLine(result, line);
        }
    }

    private static void traverseLine(List<Player> result, Line line) {
        for (int Playerindex = 0; Playerindex < line.getLine().size(); Playerindex++) {
            crossLine(result, line, Playerindex);
        }
    }

    private static void crossLine(List<Player> result, Line line, int Playerindex) {
        boolean isCross = line.getLine().get(Playerindex);

        if (isCross) {
            swapPlayers(result, Playerindex);
        }
    }

    private static void swapPlayers(List<Player> result, int i) {
        int prePlayerIndex = i;
        Player prePlayer = result.get(prePlayerIndex);

        int postPlayerIndex = prePlayerIndex + 1;
        Player postPlayer = result.get(postPlayerIndex);

        result.set(prePlayerIndex, postPlayer);
        result.set(postPlayerIndex, prePlayer);
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
