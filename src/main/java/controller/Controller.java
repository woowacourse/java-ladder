package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        PlayerNames playerNames = new PlayerNames(inputView.readPlayerNames(), inputView);
        Players players = new Players(playerNames);

        int ladderHeight = inputView.readLadderHeight();
        List<Line> ladder = generateLadder(ladderHeight, players);

        printResult(players, ladder);
    }

    private List<Line> generateLadder(int ladderHeight, Players players) {
        return IntStream.range(0, ladderHeight)
                .mapToObj(i -> generateLine(players))
                .collect(Collectors.toList());
    }

    private Line generateLine(Players players) {
        Block preBlock = new Block(booleanGenerator.generate());
        List<Block> blocks = createBlocks(players, preBlock);
        return new Line(players, blocks);
    }

    private List<Block> createBlocks(Players players, Block preBlock) {
        List<Block> blocks = new ArrayList<>(List.of(preBlock));

        IntStream.range(1, players.getPlayersSize() - 1)
                .mapToObj(i -> new Block(booleanGenerator.generate()))
                .forEach(nextBlock -> {
                    nextBlock.comparePreBlock(preBlock);
                    blocks.add(nextBlock);
                });
        return blocks;
    }

    private void printResult(Players players, List<Line> ladder) {
        outputView.printNames(players);
        outputView.printLadders(ladder);
    }
}
