package ladder.controller;

import java.util.List;
import java.util.Map;
import ladder.domain.BooleanGenerator;
import ladder.domain.GameResult;
import ladder.domain.Item;
import ladder.domain.Items;
import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {
    private static final int DIFFERENCE_PLAYERS_AND_BARS = 1;

    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanGenerator booleanGenerator;
    private GameCommand command = GameCommand.PLAY;

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
        play(ladderGame, players);
    }

    private void printAll(Players players, Items items, Ladder ladder) {
        outputView.printPlayers(players.getNameValues());
        outputView.printLadder(ladder.getLines());
        outputView.printItems(items.getNameValues());
    }

    private void play(LadderGame ladderGame, Players players) {
        GameResult gameResult = ladderGame.play();
        String name = "";
        while (command.isPlay()) {
            name = inputView.readName();
            command = GameCommand.of(name);
            printResult(players, gameResult, name);
        }
    }

    private void printResult(Players players, GameResult gameResult, String name) {
        if (command.isEnd()) {
            Map<Player, Item> result = gameResult.findAll();
            outputView.printResult(result);
            return;
        }
        Player player = players.findBy(name);
        Map<Player, Item> result = gameResult.findResult(player);
        outputView.printResult(result);
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
