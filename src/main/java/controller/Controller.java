package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanCreator booleanCreator;

    public Controller(InputView inputView, OutputView outputView, BooleanCreator booleanCreator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanCreator = booleanCreator;
    }

    public void run() {
        Players players = getPlayers();
        Rewards rewards = getRewards(players);
        Ladder ladder = getLadder(players);

        getResult(players, rewards, ladder);
        ladder.getRewardsForPlayers(players, rewards);

        selectPlayerName(players, ladder, rewards);
    }

    private void getResult(Players players, Rewards rewards, Ladder ladder) {
        outputView.printResult(players, ladder.getLadder(), rewards);
    }

    private Ladder getLadder(Players players) {
        int ladderHeight = new LadderHeight(inputView.readLadderHeight(), inputView).getLadderHeight();
        Ladder ladder = new Ladder(ladderHeight, players, booleanCreator);
        return ladder;
    }

    private Rewards getRewards(Players players) {
        Rewards rewards = new Rewards(inputView.readRewards(), players.getPlayersSize(), inputView);
        return rewards;
    }

    private Players getPlayers() {
        PlayerNames playerNames = new PlayerNames(inputView.readPlayerNames(), inputView);
        Players players = new Players(playerNames);
        return players;
    }

    private void selectPlayerName(Players players, Ladder ladder, Rewards rewards) {
        String selectedPlayerName = inputView.readSelectPlayer();
        ladder.getRewardsForPlayers(players, rewards);
        outputView.printReward(selectedPlayerName, players);
    }
}
