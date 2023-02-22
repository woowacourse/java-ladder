package controller;

import static domain.ResultCommands.*;

import java.util.List;

import domain.Ladder;
import domain.ResultCommands;
import domain.ResultTable;
import domain.Reward;
import domain.Rewards;
import domain.User;
import domain.Users;
import utils.validator.Validator;
import view.InputView;
import view.OutputView;

public class Controller {
    private final Ladder ladder;
    private final Users users;
    private final Rewards rewards;
    private final ResultTable resultTable;

    public Controller(Ladder ladder, Users users, Rewards rewards, ResultTable resultTable) {
        this.ladder = ladder;
        this.users = users;
        this.rewards = rewards;
        this.resultTable = resultTable;
    }

    public void run() {
        setLadderGame();
        printLadderMap();
        playLadderGame();
    }



    private void setLadderGame() {
        createUser();
        createRewards();
        createLadder();
    }

    private void printLadderMap() {
        OutputView.printResultMessage();
        printUsers();
        printLadder();
        printRewards();
    }

    private void playLadderGame() {
        String resultOption = InputView.readResultOption();

        if(isQuit(resultOption)) {
            return;
        }

        if(isAll(resultOption)) {
//            TODO: Map에서 null인거 찾아서 결과 돌리고 저장하기;
        }

        User user = users.findUserByName(resultOption);



    }

    private void createUser() {
        try {
            List<String> userNames = InputView.readUserNames();
            Validator.validateDuplication(userNames);
            userNames.forEach(this::setUpUser);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            createUser();
        }
    }

    private void setUpUser(String userName) {
        User newUser = new User(userName);
        users.add(newUser);
        resultTable.initialize(newUser);
    }

    private void createRewards() {
        try {
            List<String> rewardNames = InputView.readRewards();
            Validator.validateSameLength(rewardNames, users.getUserCount());
            rewardNames.forEach(rewardsName -> rewards.add(new Reward(rewardsName)));
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            createRewards();
        }
    }

    private void createLadder() {
        try {
            int ladderHeight = InputView.readLadderHeight();
            Validator.validateLadderHeight(ladderHeight);
            int userCount = users.getUserCount();
            ladder.create(ladderHeight, userCount);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            createLadder();
        }
    }

    private void printUsers() {
        List<String> userNames = users.getUserNames();
        OutputView.printUserNames(userNames);
    }

    private void printLadder() {
        List<List<Boolean>> ladderMap = ladder.getLadderMap();
        OutputView.printLadder(ladderMap);
    }

    private void printRewards() {
        List<String> rewardNames = rewards.getRewardNames();
        OutputView.printRewards(rewardNames);
    }
}
