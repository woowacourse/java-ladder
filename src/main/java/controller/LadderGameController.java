package controller;

import domain.Height;
import domain.Ladder;
import domain.LadderGame;
import domain.Rewards;
import domain.Users;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private static final String TOTAL_RESULT_KEYWORD = "all";

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Users users = getUsers();
        Rewards rewards = getRewards(users.size());
        Ladder ladder = getLadder(users.size());
        LadderGame ladderGame = new LadderGame(ladder, users, rewards);
        ladderGame.moveUsers();

        printLadderResult(ladder, users, rewards);
        confirmResult(users, ladderGame);
    }

    private void confirmResult(Users users, LadderGame ladderGame) {
        String name;

        do {
            name = getChoiceUser();
            printFinalResult(ladderGame, users, name);
        } while (!name.equals(TOTAL_RESULT_KEYWORD));
    }

    private String getChoiceUser() {
        outputView.printEnterChoiceUserNotice();
        return inputView.inputChoiceUser();
    }

    private Rewards getRewards(int userCount) {
        outputView.printEnterRewardNotice();
        List<String> rewards = inputView.inputRewards();

        return Rewards.of(rewards, userCount);
    }

    private Ladder getLadder(int userCount) {
        Height ladderHeight = getLadderHeight();

        return Ladder.of(ladderHeight, userCount);
    }

    private Users getUsers() {
        outputView.printEnterUserNotice();
        List<String> userNames = inputView.inputUsernames();

        return Users.of(userNames);
    }

    private Height getLadderHeight() {
        outputView.printEnterHeightNotice();
        int height = inputView.inputHeight();

        return new Height(height);
    }

    private void printLadderResult(Ladder ladder, Users users, Rewards rewards) {
        outputView.printGameResult(ladder, users, rewards);
    }

    private void printFinalResult(LadderGame ladderGame, Users users, String name) {
        outputView.printFinalResultNotice();
        printRewardResult(ladderGame, users, name);
    }

    private void printRewardResult(LadderGame ladderGame, Users users, String name) {
        if (name.equals(TOTAL_RESULT_KEYWORD)) {
            outputView.printTotalRewards(users, ladderGame);
            return;
        }

        outputView.printSingleReward(ladderGame, name);
    }

}
