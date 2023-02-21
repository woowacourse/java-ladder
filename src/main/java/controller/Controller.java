package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanCreator booleanCreator;

    public Controller(InputView inputView, OutputView outputView, BooleanCreator booleanCreator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanCreator = booleanCreator;
    }

    public void run() {
        PlayerNames playerNames = new PlayerNames(inputView.readPlayerNames(), inputView);
        Players players = new Players(playerNames);

        int ladderHeight = new LadderHeight(inputView.readLadderHeight(), inputView).getLadderHeight();
        List<Line> ladder = createLadder(ladderHeight, players);

        printResult(players, ladder);
    }

    private List<Line> createLadder(int ladderHeight, Players players) {
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

        IntStream.range(1, players.getPlayersSize() - 1)
                .mapToObj(i -> new Block(booleanCreator.generate()))
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
