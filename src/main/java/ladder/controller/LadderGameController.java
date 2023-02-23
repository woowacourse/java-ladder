package ladder.controller;

import java.util.List;
import java.util.Map;
import ladder.domain.BooleanGenerator;
import ladder.domain.GameResult;
import ladder.domain.Items;
import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {
    private static final int DIFFERENCE_PLAYERS_AND_BARS = 1;
    private static final String RESERVED_WORD = "all";

    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanGenerator booleanGenerator;

    public LadderGameController(InputView inputView, OutputView outputView, BooleanGenerator booleanGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanGenerator = booleanGenerator;
    }

    public void play() {
        Players players = inputPlayers();
        Items items = inputItems(players);
        Ladder ladder = inputLadder(players);

        printAll(players, items, ladder);

        LadderGame ladderGame = new LadderGame(players, ladder, items);
        play(ladderGame);
    }

    private void printAll(Players players, Items items, Ladder ladder) {
        outputView.printPlayers(players.getNameValues());
        outputView.printLadder(ladder.getLines());
        outputView.printItems(items.getNameValues());
    }

    private void play(LadderGame ladderGame) {
        GameResult gameResult = ladderGame.play();
        String name = "";
        while (!name.equals(RESERVED_WORD)) {
            name = inputView.readName();
            Map<String, String> result = gameResult.findResult(name);
            outputView.printResult(result);
        }
    }

    private Ladder inputLadder(Players players) {
        int countOfLine = inputView.readCountOfLines();
        return Ladder.generate(countOfLine, getCountOfBars(players), booleanGenerator);
    }

    private Items inputItems(Players players) {
        List<String> itemNames = inputView.readItems();
        return Items.generate(itemNames, players.getSize());
    }

    private Players inputPlayers() {
        List<String> names = inputView.readNames();
        return Players.generate(names);
    }

    private int getCountOfBars(Players players) {
        return players.getSize() - DIFFERENCE_PLAYERS_AND_BARS;
    }
}
