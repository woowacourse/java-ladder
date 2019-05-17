package laddergame.controller;

import laddergame.domain.BuilderObject;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.player.Player;
import laddergame.domain.player.PlayersBuilder;
import laddergame.domain.player.Players;
import laddergame.domain.result.RewardsBuilder;
import laddergame.domain.result.Rewards;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {

    private Players players;
    private Rewards rewards;
    private Ladder ladder;

    public LadderGameController() {
        init();
    }

    private void init() {
        this.players = assignPlayers();
        this.rewards = assignResults(players);
        LadderHeight ladderHeight = assignLadderHeight();
        this.ladder = new Ladder(ladderHeight.getLadderHeight(), players.getNumberOfPlayers());
        this.ladder.connectBridgesRandomly(ladderHeight.getLadderHeight() * players.getNumberOfPlayers());
    }


    private Players assignPlayers() {
        PlayersBuilder playersBuilder = new PlayersBuilder(InputView.inputPlayers());
        try {
            return (Players) playersBuilder.build();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return assignPlayers();
        }
    }

    private BuilderObject assignResults(Players players) {
        RewardsBuilder rewardsBuilder = new RewardsBuilder(InputView.inputPlayers());
        try {
            Rewards rewards = (Rewards) rewardsBuilder.build();
            checkPlayersWithResults(players, rewards);
            return rewards;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return assignResults(players);
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

    private void checkPlayersWithResults(BuilderObject players, BuilderObject rewards) {
        if (rewards.matchPlayersCount(players.getNumberOfPlayers())) {
            throw new IllegalArgumentException("개수가 같아야됩니다(플레이어, 결과)");
        }
    }

    public void printLadderScreen() {
        OutputView.showPlayers(this.players);
        OutputView.showLadder(this.ladder);
        OutputView.showDestinations(this.rewards);
    }

    public void proceedGame() {
        String command;
        do {
            command = InputView.inputCommand();
        } while (proceedWithCommand(command));
        OutputView.showAllResult(this.players, this.rewards, this.ladder);
    }

    private boolean proceedWithCommand(String command) {
        try {
            if (command.equals("all")) {
                return false;
            }
            OutputView.showResult(rewards.getDestination
                    (ladder.findDestinationPosition(players.getIndexOfName(command))));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }
}
