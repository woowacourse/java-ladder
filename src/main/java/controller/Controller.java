package controller;

import static domain.ResultCommands.*;

import java.util.List;

import domain.Ladder;
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
            List<User> usersWithoutReward = resultTable.getUsersWithoutReward();
            List<Integer> startIndexes = users.getIndex(usersWithoutReward);
            List<Integer> endIndexes = ladder.calculateEndIndex(startIndexes);
            List<Reward> unsavedRewards = rewards.getRewardByIndex(endIndexes);
            resultTable.saveAll(usersWithoutReward, unsavedRewards);
            OutputView.printAllResult(resultTable);
            playLadderGame();
            return;
        }

        User user = users.findUserByName(resultOption);
        Reward reward = resultTable.getRewardByUser(user);
        if(reward == null) {
            int startIndex = users.getIndex(user);
            int endIndex = ladder.calculateEndIndex(startIndex);
            reward = rewards.getRewardByIndex(endIndex);
            resultTable.save(user,reward);
        }
        OutputView.printResult(user, reward);
        playLadderGame();
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
        OutputView.printLadder(ladder);
    }

    private void printRewards() {
        List<String> rewardNames = rewards.getRewardNames();
        OutputView.printRewards(rewardNames);
    }
}
