package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private InputView inputView;
    private OutputView outputView;
    private BooleanGenerator booleanGenerator;

    public Controller(InputView inputView, OutputView outputView, BooleanGenerator booleanGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanGenerator = booleanGenerator;
    }

    public void run() {
        List<String> playerNames = inputView.readPlayerName();
        Players players = Players.generatePlayer(playerNames);

        int ladderHeight = inputView.readLadderHeight();
        List<Line> ladder = generateLadder(ladderHeight, players);

        printResult(players, ladder);
    }

    private List<Line> generateLadder(int ladderHeight, Players players) {
        List<Line> list = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            Line line = generateLine(players);
            list.add(line);
        }
        return list;
    }

    private Line generateLine(Players players) {
        Block preBlock = new Block(booleanGenerator.generate());
        List<Block> blocks = createBlocks(players, preBlock);
        return new Line(players, blocks);
    }

    private List<Block> createBlocks(Players players, Block preBlock) {
        List<Block> blocks = new ArrayList<>(List.of(preBlock));

        int bound = players.getPlayersSize() - 1;
        for (int i = 1; i < bound; i++) {
            Block nextBlock = Block.createNextBlock(blocks.get(i-1), booleanGenerator);
            blocks.add(nextBlock);
        }
        return blocks;
    }

    private void printResult(Players players, List<Line> ladder) {
        outputView.printNames(players);
        outputView.printLadders(ladder);
    }
}
