package LadderGame;

import domain.*;
import view.InputView;
import view.OutputView;

public class LadderGame {
    private final BooleanCreator booleanCreator;

    public LadderGame(BooleanCreator booleanCreator) {
        this.booleanCreator = booleanCreator;
    }

    public void start() {
        Players players = validatePlayersInput();
        Rewards rewards = validateRewardsInput(players);
        Ladder ladder = validateLadderInput(players);

        printLadders(players, rewards, ladder);
        ladder.getRewardsForPlayers(rewards);

        selectPlayerName(players,rewards);
    }

    private Players validatePlayersInput() {
        Players players;
        try {
            players = createPlayers();
        } catch (Exception exception) {
            InputView.printErrorMessage(exception.getMessage());
            players = validatePlayersInput();
        }
        return players;
    }

    private Players createPlayers() {
        PlayerNames playerNames = new PlayerNames(InputView.readPlayerNames());
        return new Players(playerNames);
    }


    private Rewards validateRewardsInput(Players players) {
        Rewards rewards;
        try {
            rewards = createRewards(players);
        } catch (Exception exception) {
            InputView.printErrorMessage(exception.getMessage());
            rewards = validateRewardsInput(players);
        }
        return rewards;
    }

    private Rewards createRewards(Players players) {
        return new Rewards(InputView.readRewards(), players.getPlayersSize());
    }

    private Ladder validateLadderInput(Players players) {
        Ladder ladder;
        try {
            ladder = createLadder(players);
        } catch (Exception exception) {
            InputView.printErrorMessage(exception.getMessage());
            ladder = validateLadderInput(players);
        }
        return ladder;
    }

    private Ladder createLadder(Players players) {
        int ladderHeight = new LadderHeight(InputView.readLadderHeight()).getLadderHeight();
        return new Ladder(ladderHeight, players, booleanCreator);
    }

    private void printLadders(Players players, Rewards rewards, Ladder ladder) {
        OutputView.printResult(players, ladder.getLadder(), rewards);
    }

    private void selectPlayerName(Players players,Rewards rewards) {
        String selectedPlayerName = InputView.readSelectPlayer();
        OutputView.printReward(selectedPlayerName, players,rewards);
    }
}
