package laddergame.controller;

import laddergame.NameList;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.player.PlayersFactory;
import laddergame.domain.result.GameResult;
import laddergame.domain.reward.RewardsFactory;
import laddergame.domain.reward.Rewards;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {

    private GameResult ladderGameResult;

    public LadderGameController() {
        init();
    }

    private void init() {
        NameList players = assignPlayers();
        NameList rewards = assignRewards(players);
        LadderHeight ladderHeight = assignLadderHeight();
        Ladder ladder = new Ladder(ladderHeight.getLadderHeight(), players.getSize());
        ladder.connectBridgesRandomly(ladderHeight.getLadderHeight() * players.getSize());
        this.ladderGameResult = GameResult.of(players, rewards, ladder);

        printLadderGameScreen(players, ladder, rewards);
    }


    private NameList assignPlayers() {
        PlayersFactory playersFactory = new PlayersFactory(InputView.inputPlayers());
        try {
            return playersFactory.create();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return assignPlayers();
        }
    }

    private NameList assignRewards(NameList players) throws IllegalArgumentException {
        RewardsFactory rewardsFactory = new RewardsFactory(InputView.inputRewards());
        try {
            Rewards rewards = (Rewards) rewardsFactory.create();
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

    private void checkPlayersWithRewards(NameList players, NameList rewards) {
        if (!rewards.isSizeEqual(players)) {
            throw new IllegalArgumentException("결과를 참여자와 같은 개수로 입력하세요");
        }
    }

    private void printLadderGameScreen(NameList players, Ladder ladder, NameList rewards) {
        OutputView.showPlayers(players);
        OutputView.showLadder(ladder);
        OutputView.showRewards(rewards);
    }

    public void proceedGame() {
        String command;
        do {
            command = InputView.inputCommand();
        } while (proceedWithCommand(command));
        OutputView.showAllResult(this.ladderGameResult.getAllGameResultFormat());
    }

    private boolean proceedWithCommand(String command) {
        try {
            if (command.equals("all")) {
                return false;
            }
            OutputView.showResult(this.ladderGameResult.getGameResultFormat(command));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }
}
