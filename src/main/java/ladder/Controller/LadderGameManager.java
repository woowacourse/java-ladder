package ladder.Controller;

import ladder.View.OutputView;
import ladder.domain.*;
import ladder.View.InputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGameManager {
    private List<Player> players;
    private List<Line> createdLadder;
    private Map<String, String> gameReward;

    public void start() {
        registerGameEnv();
        play();
        OutputView.ladderResult(players, createdLadder, gameReward);
        gameResult(players, gameReward);
    }

    private void registerGameEnv() {
        registerPlayers();
        registerGameReward();
        registerCreatedLadder();
    }

    private void registerPlayers() {
        PlayerManager playerManager = new PlayerManager();
        playerManager.createPlayers(InputModel.getValidNames(InputView.getNames()));
        players = playerManager.getPlayers();
    }

    private void registerGameReward() {
        gameReward = new HashMap<>();
        gameReward = InputModel.getWrappedValidReward(getValidReward());
    }

    private List<String> getValidReward() {
        return InputModel.getValidReward(InputView.getGameReward(), players.size());
    }

    private void registerCreatedLadder() {
        Ladder ladder = new Ladder();

        int ladderHeight = InputModel.getValidLadderHeight(InputView.getLadderHeight());
        ladder.createLadder(ladderHeight, players.size());
        createdLadder = ladder.getLadder();
    }

    private void play() {
        LadderGame ladderGame = new LadderGame(players, createdLadder);
        ladderGame.runGame();
    }


    private void gameResult(List<Player> players, Map<String, String> gameRewards) {
        String playerName = InputView.getWantToKnowResult();

        if (playerName.equals("all")) {
            OutputView.printAllPlayersResult(players, gameRewards);
            return;
        }

        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                OutputView.printOnePlayerResult(player, gameRewards);
            }
        }

        gameResult(players, gameRewards);
    }
}
