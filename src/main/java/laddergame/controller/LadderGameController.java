package laddergame.controller;

import laddergame.BuilderObject;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.player.PlayersBuilder;
import laddergame.domain.result.GameResult;
import laddergame.domain.reward.RewardsBuilder;
import laddergame.domain.reward.Rewards;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {

    private BuilderObject players;
    private BuilderObject rewards;
    private Ladder ladder;
    // TODO 멤버 변수 지울방법 무조건 찾아볼 것
    private GameResult tempGameResult;

    public LadderGameController() {
        init();
    }

    private void init() {
        this.players = assignPlayers();
        this.rewards = assignRewards(players);
        LadderHeight ladderHeight = assignLadderHeight();
        this.ladder = new Ladder(ladderHeight.getLadderHeight(), players.getSize());
        this.ladder.connectBridgesRandomly(ladderHeight.getLadderHeight() * players.getSize());
        this.tempGameResult = GameResult.of(this.players, this.rewards, this.ladder);
    }


    private BuilderObject assignPlayers() {
        PlayersBuilder playersBuilder = new PlayersBuilder(InputView.inputPlayers());
        try {
            return playersBuilder.createElement();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return assignPlayers();
        }
    }

    private BuilderObject assignRewards(BuilderObject players) throws IllegalArgumentException {
        RewardsBuilder rewardsBuilder = new RewardsBuilder(InputView.inputPlayers());
        try {
            Rewards rewards = (Rewards) rewardsBuilder.createElement();
            checkPlayersWithRewards(players, rewards);
            return rewards;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return assignRewards(players);
        }
    }


    private LadderHeight assignLadderHeight() {
        try {
            return new LadderHeight(InputView.inputLadderHeight());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return assignLadderHeight();
        }
    }

    private void checkPlayersWithRewards(BuilderObject players, BuilderObject rewards) {
        if (!rewards.isSizeEqual(players)) {
            throw new IllegalArgumentException("결과를 참여자와 같은 개수로 입력하세요");
        }
    }

    public void printLadderScreen() {
        OutputView.showPlayers(this.players);
        OutputView.showLadder(this.ladder);
        OutputView.showRewards(this.rewards);
    }

    public void proceedGame() {
        String command;
        do {
            command = InputView.inputCommand();
        } while (proceedWithCommand(command));
        // 종료시
        OutputView.showAllResult(this.tempGameResult.getAllGameResultFormat());
    }

    private boolean proceedWithCommand(String command) {
        try {
            if (command.equals("all")) {
                return false;
            }
            OutputView.showResult(this.tempGameResult.getGameResultFormat(command));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;    // 반복
        }
    }
}
