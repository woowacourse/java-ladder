package controller;

import java.util.Arrays;
import model.Command;
import model.LadderGame;
import model.ladder.Ladder;
import model.people.People;
import model.prizes.Prize;
import model.prizes.RewardBoard;
import utils.RandomThresholdChecker;
import view.InputView;
import view.ResultView;

public class LadderController {
    private static final String INPUT_PARSE_DELIMITER = ",";

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
            handler.handleWithRetry(() -> processInputAndGetPrize(ladderGame.getPeople()));
        }
    }

    private void processInputAndGetPrize(People people) {
        String commandInputText = inputView.askForParticipantName();
        Command command = Command.inputTextToCommand(commandInputText);
        if (command == Command.EXIT) {
            terminateGame();
            return;
        }
        if (command == Command.ALL) {
            getAllPrize(people);
            return;
        }
        getPrize(commandInputText);
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

    private void launchGame() {
        People people = handler.handleWithRetry(() -> new People(inputView.askParticipants()));
        Ladder ladder = handler.handleWithRetry(() ->
                new Ladder(new RandomThresholdChecker(),
                        inputView.askLadderHeight(),
                        people.getParticipantsSize()));

        String prizesText = handler.handleWithRetry(() -> makeLadder(people, ladder));
        resultView.printLadderResult(people, ladder);
        resultView.printPrizes(Arrays.stream(prizesText.split(INPUT_PARSE_DELIMITER)).toList());
    }

    private String makeLadder(People people, Ladder ladder) {
        String prizesText = inputView.askPrizeNames();
        ladderGame = new LadderGame(people, ladder, prizesText);
        return prizesText;
    }

}
