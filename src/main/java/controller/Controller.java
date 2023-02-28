package controller;

import domain.Height;
import domain.Ladder;
import domain.LadderGame;
import domain.LadderGameResult;
import domain.Reward;
import domain.Rewards;
import domain.User;
import domain.Users;
import java.util.List;
import java.util.stream.Collectors;
import utils.LadderRowGenerator;
import view.InputView;
import view.OutputView;

public class Controller {

    private final LadderRowGenerator ladderRowGenerator;

    public Controller(final LadderRowGenerator ladderRowGenerator) {
        this.ladderRowGenerator = ladderRowGenerator;
    }

    public void run() {
        Users users = getUsers();
        Rewards rewards = getRewards(users.getSize());
        Height height = getHeight();
        Ladder ladder = getLadder(users, height);

        LadderGame ladderGame = getLadderGame(ladder, users, rewards);
        OutputView.printLadderGame(ladderGame);

        ladderGame.play();
        searchResult(ladderGame);
    }

    private Users getUsers() {
        try {
            List<String> userNames = InputView.readUserNames();
            List<User> users = userNames.stream()
                    .map(User::new)
                    .collect(Collectors.toList());
            return new Users(users);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getUsers();
        }
    }

    private Rewards getRewards(int userCount) {
        try {
            List<String> rewardNames = InputView.readRewardNames();
            List<Reward> rewards = rewardNames.stream()
                    .map(Reward::new)
                    .collect(Collectors.toList());
            return new Rewards(rewards, userCount);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getRewards(userCount);
        }
    }

    private Height getHeight() {
        try {
            int height = InputView.readLadderHeight();
            return new Height(height);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getHeight();
        }
    }

    private Ladder getLadder(final Users users, final Height height) {
        return new Ladder(users.getSize(), height.getHeight(), ladderRowGenerator);
    }

    private LadderGame getLadderGame(final Ladder ladder, final Users users, final Rewards rewards) {
        return new LadderGame(ladder, users, rewards);
    }

    private void searchResult(final LadderGame ladderGame) {
        while (ladderGame.isInProgress()) {
            LadderGameResult ladderGameResult = getLadderGameResult(ladderGame);
            OutputView.printLadderGameResult(ladderGameResult);
        }
    }

    private LadderGameResult getLadderGameResult(final LadderGame ladderGame) {
        try {
            String rewardViewer = InputView.readRewardViewer();
            return ladderGame.getLadderGameResultByName(rewardViewer);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getLadderGameResult(ladderGame);
        }
    }
}
