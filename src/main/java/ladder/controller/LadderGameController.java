package ladder.controller;

import java.util.List;
import java.util.Map;
import ladder.domain.GameResult;
import ladder.domain.Items;
import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.Players;
import ladder.domain.RandomBooleanGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {
    private static final int DIFFERENCE_PLAYERS_AND_BARS = 1;
    private static final String RESERVED_WORD = "all";

    public void run() {
        Players players = inputPlayers();
        Items items = inputItems(players);
        Ladder ladder = inputLadder(players);

        printAll(players, items, ladder);

        LadderGame ladderGame = new LadderGame(players, ladder, items);
        run(ladderGame);
    }

    private void printAll(Players players, Items items, Ladder ladder) {
        OutputView.printPlayers(players.getNameValues());
        OutputView.printLadder(ladder.getLines());
        OutputView.printItems(items.getNameValues());
    }

    private void run(LadderGame ladderGame) {
        GameResult gameResult = ladderGame.play();
        String name = "";
        while (!name.equals(RESERVED_WORD)) {
            name = InputView.readName();
            Map<String, String> result = gameResult.findResult(name);
            OutputView.printResult(result);
        }
    }

    private Ladder inputLadder(Players players) {
        int countOfLine = InputView.readCountOfLines();
        return Ladder.generate(countOfLine, getCountOfBars(players), new RandomBooleanGenerator());
    }

    private Items inputItems(Players players) {
        List<String> itemNames = InputView.readItems();
        return Items.generate(itemNames, players.getSize());
    }

    private Players inputPlayers() {
        List<String> names = InputView.readNames();
        return Players.generate(names);
    }

    private int getCountOfBars(Players players) {
        return players.getSize() - DIFFERENCE_PLAYERS_AND_BARS;
    }
}
