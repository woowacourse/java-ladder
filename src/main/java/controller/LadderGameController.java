package controller;

import java.util.List;
import java.util.stream.Collectors;

import domain.*;

import view.InputView;
import view.OutputView;

public class LadderGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RandomDigitsGenerator generator;

    public LadderGameController(InputView inputView, OutputView outputView, RandomDigitsGenerator generator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.generator = generator;
    }

    public void run() {
        Players players = getPlayers();
        Prizes prizes = getPrizes(players);
        Ladder ladder = getLadder(players.getCount() - 1);
        LadderGame ladderGame = new LadderGame(players, ladder);

        printLadderInformation(players, prizes, ladder);
        printPlayerResult(players, prizes, ladderGame);
    }

    private void printLadderInformation(Players players, Prizes prizes, Ladder ladder) {
        outputView.printNames(players.getNames());
        outputView.printLadder(ladder.getLines());
        outputView.printNames(prizes.getNames());
    }

    private void printPlayerResult(Players players, Prizes prizes, LadderGame ladderGame) {
        List<Integer> indexs = getPlayerIndex(ladderGame);
        while (indexs.size() == 1) {
            outputView.printPlayerResult(prizes.getName(indexs.get(0)));
            indexs = getPlayerIndex(ladderGame);
        }
        List<String> results = indexs.stream().map(prizes::getName).collect(Collectors.toList());
        outputView.printAllPlayerResult(players, results);
    }

    private List<Integer> getPlayerIndex(LadderGame ladderGame) {
        try {
            String name = inputView.readCheckPlayer();
            return ladderGame.getResult(name);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getPlayerIndex(ladderGame);
        }
    }

    private Players getPlayers() {
        try {
            List<String> names = inputView.readPlayerNames();
            return new Players(names);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getPlayers();
        }
    }

    private Prizes getPrizes(Players players) {
        try {
            List<String> names = inputView.readPrizeNames();
            Prizes prizes = new Prizes(names, players);
            return prizes;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getPrizes(players);
        }
    }

    private Ladder getLadder(int width) {
        try {
            int height = inputView.readLadderHeight();
            return new Ladder(height, width, generator);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getLadder(width);
        }
    }

}



