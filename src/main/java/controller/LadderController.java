package controller;

import handler.ExceptionHandler;
import java.util.Arrays;
import model.Ladder;
import model.LadderGame;
import model.People;
import model.Prize;
import model.RewardBoard;
import utils.ThresholdCheckerImpl;
import view.InputView;
import view.ResultView;

public class LadderController {
    private static final String DELIMITER = ",";
    private static final String ALL_COMMAND = "all";
    private static final String EXIT_COMMAND = "exit";

    private final ResultView resultView;
    private final InputView inputView;
    private final ExceptionHandler handler;
    private LadderGame ladderGame;

    public LadderController() {
        this.resultView = new ResultView();
        this.inputView = new InputView();
        handler = new ExceptionHandler();
    }

    public void proceedGame() {
        launchGame();
        while (true) {
            handler.handleWithRetry(() -> insertAndProceedCommand(ladderGame.getPeople()));
        }
    }

    private void launchGame() {
        People people = handler.handleWithRetry(() -> new People(inputView.askParticipants()));
        Ladder ladder = handler.handleWithRetry(() ->
                new Ladder(new ThresholdCheckerImpl(),
                inputView.askLadderHeight(),
                people.getParticipantsSize()));

        String prizesText = inputView.askPrizes();
        ladderGame = handler.handleWithRetry(() -> new LadderGame(people, ladder, prizesText));
        resultView.printLadderResult(people, ladder);
        resultView.printPrizes(Arrays.stream(prizesText.split(DELIMITER)).toList());
    }

    private void insertAndProceedCommand(People people) {
        String command = inputView.askGameResult();
        if (isAll(command)) {
            getAllPrize(people);
            return;
        }
        if (isExit(command)) {
            terminateGame();
            return;
        }
        getPrize(command);
    }

    private void getPrize(String participantName) {
        RewardBoard rewardBoard = ladderGame.getRewardBoard();
        Prize findPrize = rewardBoard.findPrizeByName(participantName);
        resultView.printProceedResult(findPrize);
    }

    private void getAllPrize(People people) {
        RewardBoard rewardBoard = ladderGame.getRewardBoard();
        resultView.printAllProceedResult(rewardBoard, people);
    }

    private void terminateGame() {
        System.exit(0);
    }

    private boolean isAll(String command) {
        return command.equals(ALL_COMMAND);
    }

    private boolean isExit(String command) {
        return command.equals(EXIT_COMMAND);
    }
}
