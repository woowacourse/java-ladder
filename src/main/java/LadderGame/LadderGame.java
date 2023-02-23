package LadderGame;

import domain.*;
import view.InputView;
import view.OutputView;

public class LadderGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanCreator booleanCreator;

    public LadderGame(InputView inputView, OutputView outputView, BooleanCreator booleanCreator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanCreator = booleanCreator;
    }

    public void ladderGame() {
        Players players = createPlayers();
        Rewards rewards = createRewards(players);
        Ladder ladder = createLadder(players);

        printLadders(players, rewards, ladder);
        ladder.getRewardsForPlayers(rewards);

        selectPlayerName(players);
    }

    private Players createPlayers() {
        PlayerNames playerNames = new PlayerNames(inputView.readPlayerNames(), inputView);
        Players players = new Players(playerNames);
        return players;
    }

    private Rewards createRewards(Players players) {
        Rewards rewards = new Rewards(inputView.readRewards(), players.getPlayersSize(), inputView);
        return rewards;
    }

    private Ladder createLadder(Players players) {
        int ladderHeight = new LadderHeight(inputView.readLadderHeight(), inputView).getLadderHeight();
        Ladder ladder = new Ladder(ladderHeight, players, booleanCreator);
        return ladder;
    }

    private void printLadders(Players players, Rewards rewards, Ladder ladder) {
        outputView.printResult(players, ladder.getLadder(), rewards);
    }

    private void selectPlayerName(Players players) {
        String selectedPlayerName = inputView.readSelectPlayer();
        outputView.printReward(selectedPlayerName, players);
    }
}
