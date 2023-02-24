package controller;

import java.util.List;

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
        Prizes prizes = getPrizes(players.getCount());
        Ladder ladder = getLadder(players.getCount() - 1);
        LadderGame ladderGame = new LadderGame(players, ladder);

        printLadderInformation(players, prizes, ladder);
        printPlayerResult(players, prizes, ladderGame);
    }

    private void printPlayerResult(Players players, Prizes prizes, LadderGame ladderGame) {
        while (true) {
            int index = getPlayerIndex(ladderGame);
            if (index == -10) {
                outputView.printAllPlayerResult(players, ladderGame.getResultAllIndex());
                break;
            }
            outputView.printPlayerResult(prizes.getName(index));
        }
    }

    private void printLadderInformation(Players players, Prizes prizes, Ladder ladder) {
        outputView.printNames(players.getNames());
        outputView.printLadder(ladder.getLines());
        outputView.printNames(prizes.getNames());
    }

    private int getPlayerIndex(LadderGame ladderGame) {
        try {
            String name = inputView.readCheckPlayer();
            if (name.equals("all")) {
                return -10;
            }
            return ladderGame.getResultIndex(name);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getPlayerIndex(ladderGame);
        }
    }

    private Prizes getPrizes(int count) {
        try {
            List<String> names = inputView.readPrizeNames();
            Prizes prizes = new Prizes(names);
            validatePrizesCount(prizes, count);
            return prizes;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getPrizes(count);
        }
    }

    private void validatePrizesCount(Prizes prizes, int count) {
        if (!prizes.isSame(count)) {
            throw new IllegalArgumentException("실행결과 수는 참여자 수와 같아야합니다.");
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



