package controller;

import java.util.List;
import java.util.stream.Collectors;

import domain.Ladder;
import domain.Players;
import domain.Prizes;
import domain.RandomDigitsGenerator;
import domain.LadderGame;

import view.InputView;
import view.OutputView;

public class LadderGameController {

    private static final int SINGLE_RESULT_SIZE = 1;
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

        printLadderInformation(players, ladder, prizes);
        printPlayerResult(players, prizes, ladderGame);
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
            return new Prizes(names, players);
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

    private void printLadderInformation(Players players, Ladder ladder, Prizes prizes) {
        outputView.printNames(players.getNames());
        outputView.printLadder(ladder.getLines());
        outputView.printNames(prizes.getNames());
    }

    private void printPlayerResult(Players players, Prizes prizes, LadderGame ladderGame) {
        List<Integer> indexs = getPlayerResultIndex(ladderGame);
        while (isSingleResult(indexs)) {
            String result = prizes.getName(indexs.get(0));
            outputView.printSinglePlayerResult(result);
            indexs = getPlayerResultIndex(ladderGame);
        }
        List<String> results = indexs.stream()
                .map(prizes::getName).collect(Collectors.toList());
        outputView.printAllPlayerResult(players, results);
    }

    private boolean isSingleResult(List<Integer> indexes) {
        return indexes.size() == SINGLE_RESULT_SIZE;
    }

    private List<Integer> getPlayerResultIndex(LadderGame ladderGame) {
        try {
            String name = inputView.readCheckPlayer();
            return ladderGame.getResult(name);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getPlayerResultIndex(ladderGame);
        }
    }

}



