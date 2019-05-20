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
    private Map<Integer, String> gameReward;

    public void start() {
        registerPlayers();
        registerGameReward();
        registerCreatedLadder();

        play();
        OutputView.ladderGameResult(players, createdLadder, gameReward);
    }

    private void registerPlayers() {
        InputModel inputModel = new InputModel();
        PlayerManager playerManager = new PlayerManager();

        playerManager.createPlayers(inputModel.getValidNames(InputView.getNames()));
        players = playerManager.getPlayers();
    }

    private void registerGameReward() {
        gameReward = new HashMap<>();
        InputModel inputModel = new InputModel();

        gameReward = inputModel.getWrappedValidReward(inputModel.getValidReward(InputView.getGameReward(), players.size()));
    }

    private void registerCreatedLadder() {
        InputModel inputModel = new InputModel();
        Ladder ladder = new Ladder();

        int ladderHeight = inputModel.getValidLadderHeight(InputView.getLadderHeight());
        ladder.createLadder(ladderHeight, players.size());
        createdLadder = ladder.getLadder();
    }

    private void play() {
        LadderGame ladderGame = new LadderGame(players, createdLadder);
        ladderGame.runGame();
    }
}
