package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> ladder;
    private final List<Player> result;
    private final BooleanCreator booleanCreator;

    public Ladder(int ladderHeight, Players players, BooleanCreator booleanCreator) {
        this.result = players.getPlayers();
        this.booleanCreator = booleanCreator;
        this.ladder = createLadder(ladderHeight, players);
    }

    public List<Line> createLadder(int ladderHeight, Players players) {
        return IntStream.range(0, ladderHeight)
                .mapToObj(i -> createLine(players))
                .collect(Collectors.toList());
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

    public void getRewardsForPlayers(Rewards rewards) {
        traverseLines();
        matchRewardsForPlayers(rewards);
    }

    private void traverseLines() {
        for (Line line : ladder) {
            traverseLine(line);
        }
    }

    private void traverseLine(Line line) {
        for (int playerIndex = 0; playerIndex < line.getBlocksSize(); playerIndex++) {
            crossLine(line, playerIndex);
        }
    }

    private void crossLine(Line line, int playerIndex) {
        boolean isCross = line.getBlockByIndex(playerIndex);

        //TODO: isCross, isCrossable 둘 중에 더 직관적인 네이밍은 어떤 것일까요??
        if (isCross) {
            swapPlayers(playerIndex);
        }
    }

    private void swapPlayers(int playerIndex) {
        int prePlayerIndex = playerIndex;
        Player prePlayer = result.get(prePlayerIndex);

        int postPlayerIndex = prePlayerIndex + 1;
        Player postPlayer = result.get(postPlayerIndex);

        result.set(prePlayerIndex, postPlayer);
        result.set(postPlayerIndex, prePlayer);
    }

    private void matchRewardsForPlayers(Rewards rewards) {
        IntStream.range(0, result.size()).forEach(playerIndex -> {
            Player player = result.get(playerIndex);
            player.setReward(rewards.getReward(playerIndex));
        });
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
