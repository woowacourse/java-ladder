package ladder.Controller;

import ladder.View.OutputView;
import ladder.domain.*;
import ladder.View.InputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGameManager {
    private static final String ALL_PLAYERS = "all";

    private List<Player> players;
    private List<Line> createdLadder;
    private Map<Integer, String> gameReward;

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
        List<String> names = InputModel.getValidNames(InputView.getNames());
        players = new ArrayList<>();

        for (String name : names) {
            players.add(new Player(name, players.size()));
        }
    }

    private void registerGameReward() {
        gameReward = new HashMap<>();
        gameReward = InputModel.getMappingValidReward(getValidReward());
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


    private void gameResult(List<Player> players, Map<Integer, String> gameRewards) {
        String playerName = InputModel.getValidWantToKnowPlayer(InputView.getWantToKnowResult());

        if (isAllPlayerResult(players, gameRewards, playerName)) {
            return;
        }
        for (Player player : players) {
            matchedPlayerResult(gameRewards, playerName, player);
        }

        gameResult(players, gameRewards);
    }

    private boolean isAllPlayerResult(List<Player> players, Map<Integer, String> gameRewards, String playerName) {
        if (playerName.equals(ALL_PLAYERS)) {
            OutputView.printAllPlayersResult(players, gameRewards);
            return true;
        }

        return false;
    }

    private void matchedPlayerResult(Map<Integer, String> gameRewards, String playerName, Player player) {
        if (player.getName().equals(playerName)) {
            OutputView.printOnePlayerResult(player, gameRewards);
        }
    }
}
