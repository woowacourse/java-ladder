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
        Players players = createPlayers();
        Rewards rewards = createRewards(players);
        Ladder ladder = createLadder(players);

        printLadders(players, rewards, ladder);
        ladder.getRewardsForPlayers(rewards);

        selectPlayerName(players);
    }

    private void printLadders(Players players, Rewards rewards, Ladder ladder) {
        outputView.printResult(players, ladder.getLadder(), rewards);
    }

    private Ladder createLadder(Players players) {
        int ladderHeight = new LadderHeight(inputView.readLadderHeight(), inputView).getLadderHeight();
        Ladder ladder = new Ladder(ladderHeight, players, booleanCreator);
        return ladder;
    }

    private Rewards createRewards(Players players) {
        Rewards rewards = new Rewards(inputView.readRewards(), players.getPlayersSize(), inputView);
        return rewards;
    }

    private Players createPlayers() {
        PlayerNames playerNames = new PlayerNames(inputView.readPlayerNames(), inputView);
        Players players = new Players(playerNames);
        return players;
    }

    private void selectPlayerName(Players players) {
        String selectedPlayerName = inputView.readSelectPlayer();
        outputView.printReward(selectedPlayerName, players);
    }
}
