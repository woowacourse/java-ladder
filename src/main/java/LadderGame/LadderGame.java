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
        Players players = validatePlayersInput();
        Rewards rewards = validateRewardsInput(players);
        Ladder ladder = validateLadderInput(players);

        printLadders(players, rewards, ladder);
        ladder.getRewardsForPlayers(rewards);

        selectPlayerName(players);
    }

    private Players validatePlayersInput() {
        Players players;
        try {
            players = createPlayers();
        } catch (Exception exception) {
            inputView.printErrorMessage(exception.getMessage());
            players = validatePlayersInput();
        }
        return players;
    }

    private Players createPlayers() {
        PlayerNames playerNames = new PlayerNames(inputView.readPlayerNames());
        return new Players(playerNames);
    }


    private Rewards validateRewardsInput(Players players) {
        Rewards rewards;
        try {
            rewards = createRewards(players);
        } catch (Exception exception) {
            inputView.printErrorMessage(exception.getMessage());
            rewards = validateRewardsInput(players);
        }
        return rewards;
    }

    private Rewards createRewards(Players players) {
        return new Rewards(inputView.readRewards(), players.getPlayersSize());
    }

    private Ladder validateLadderInput(Players players) {
        Ladder ladder;
        try {
            ladder = createLadder(players);
        } catch (Exception exception) {
            inputView.printErrorMessage(exception.getMessage());
            ladder = validateLadderInput(players);
        }
        return ladder;
    }

    private Ladder createLadder(Players players) {
        int ladderHeight = new LadderHeight(inputView.readLadderHeight()).getLadderHeight();
        return new Ladder(ladderHeight, players, booleanCreator);
    }

    private void printLadders(Players players, Rewards rewards, Ladder ladder) {
        outputView.printResult(players, ladder.getLadder(), rewards);
    }

    private void selectPlayerName(Players players) {
        String selectedPlayerName = inputView.readSelectPlayer();
        outputView.printReward(selectedPlayerName, players);
    }
}
