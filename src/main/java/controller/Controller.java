package controller;

import model.*;
import model.LadderHeight;
import model.Winner;
import util.GameStrategy;
import util.LadderGameStrategy;
import util.LineGenerator;
import view.InputView;
import view.OutputView;

public class Controller {
    private InputView inputView;
    private OutputView outputView;
    private GameStrategy gameStrategy = new LadderGameStrategy();

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Names names = setNames();
        LadderGoal ladderGoal = setLadderGoal(names.getNamesSize());
        LadderHeight ladderHeight = setLadderHeight();
        Ladder ladder = new Ladder(names.getNamesSize(), ladderHeight, new LineGenerator());
        Game game = new Game(names, ladderGoal, ladder, gameStrategy);
        printLadder(names, ladder, ladderHeight, ladderGoal);
        playLadderGame(game, names);
    }

    private Names setNames() {
        outputView.printPlayerNamesMessage();
        try {
            return new Names(inputView.readPlayerNames());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return setNames();
        }
    }

    private LadderHeight setLadderHeight() {
        outputView.printLadderHeightMessage();
        try {
            return new LadderHeight(inputView.readLadderHeight());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return setLadderHeight();
        }
    }

    private LadderGoal setLadderGoal(int personCount) {
        outputView.printExecutionGoalMessage();
        try {
            return new LadderGoal(inputView.readLadderGoal(), personCount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return setLadderGoal(personCount);
        }
    }

    private void printLadder(Names names, Ladder ladder, LadderHeight ladderHeight,
                             LadderGoal goal) {
        outputView.printLadderResultMessage();
        outputView.printName(names);
        outputView.printLadder(names, ladder, ladderHeight);
        outputView.printLadderGoal(goal);
    }

    private void playLadderGame(Game game, Names names) {
        Winner winnerName;
        do {
            winnerName = setWinner(names);
            outputView.printWinnerExecutionResultMessage();
            printWinnerResult(winnerName, game);
        }
        while (!winnerName.isAllEndWinner());
    }

    private Winner setWinner(Names names) {
        outputView.printWinnerResultMessage();
        try {
            return new Winner(names, inputView.readWinnerResult());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return setWinner(names);
        }
    }

    private void printWinnerResult(Winner winner, Game game) {
        if (winner.isAllEndWinner()) {
            outputView.printWinnerGameAllResult(game.getPrizeWinners());
            return;
        }
        outputView.printWinnerGameResult(game.getPrizeIndividualWinner(winner));
    }
}
