package ladder.Controller;

import ladder.domain.*;
import ladder.View.InputView;

import java.util.List;

public class LadderGameManager {
    private List<Player> players;
    private List<Line> createdLadder;

    public void start() {
        registerPlayers();

        registerCreatedLadder();


    }

    private void registerCreatedLadder() {
        InputModel inputModel = new InputModel();
        Ladder ladder = new Ladder();

        int ladderHeight = inputModel.getValidLadderHeight(InputView.getLadderHeight());
        ladder.createLadder(ladderHeight, players.size());
        createdLadder = ladder.getLadder();
    }

    private void registerPlayers() {
        InputModel inputModel = new InputModel();
        PlayerManager playerManager = new PlayerManager();

        playerManager.createPlayers(inputModel.getValidNames(InputView.getNames()));
        players = playerManager.getPlayers();
    }
}
