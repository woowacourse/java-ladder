package controller;

import java.util.List;

import domain.Ladder;
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

    public Controller(Ladder ladder, Users users, Rewards rewards) {
        this.ladder = ladder;
        this.users = users;
        this.rewards = rewards;
    }

    public void run() {
        createUser();
        createRewards();
        createLadder();
        OutputView.printResultMessage();
        printUsers();
        printLadder();
    }

    private void createUser() {
        try {
            List<String> userNames = InputView.readUserNames();
            Validator.validateDuplication(userNames);
            userNames.forEach(userName -> users.add(new User(userName)));
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            createUser();
        }
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
}
