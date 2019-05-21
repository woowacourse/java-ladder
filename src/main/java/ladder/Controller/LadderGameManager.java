package ladder.Controller;

import ladder.View.InputView;
import ladder.View.OutputView;
import ladder.domain.*;

import java.util.ArrayList;
import java.util.List;

public class LadderGameManager {
    private List<Player> players;
    private List<String> names;
    private Ladder ladder ;

    public LadderGameManager() {
        players = new ArrayList<>();
        names = new ArrayList<>();
        ladder = new Ladder();
    }

    public void start() {
        InputManager inputManager = new InputManager();
        names = inputManager.getValidNames(InputView.getNames());
        List<String> executeResult = inputManager.getValidExecuteResult(InputView.getExecuteResult(), names.size());
        int ladderHeight = inputManager.getValidLadderHeight(InputView.getLadderHeight());
        ladder.createLadder(names.size(), ladderHeight);
        createPlayers();

        ladderMove(ladderHeight);
        output(executeResult);
    }

    private void createPlayers() {
        for (int i = 0; i < names.size(); i++) {
            players.add(i, new Player(names.get(i), i));
        }
    }

    private void ladderMove(int ladderHeight) {
        for (int i = 0; i < players.size(); i++) {
            moveLadderHeight(i, ladderHeight);
        }
    }

    private void moveLadderHeight(int playerNumber, int ladderHeight) {
        for (int j = 0; j < ladderHeight; j++) {
            players.get(playerNumber).move(players.size(),checkPlayerDirection(j,players.get(playerNumber).getPosition()));
            players.set(playerNumber, getPlayer(playerNumber));
        }
    }

    private Direction checkPlayerDirection(int height, int playerPosition) {
        return ladder.getCurrentDirection(height,playerPosition);
    }

    private Player getPlayer(int playerNumber) {
        return new Player(names.get(playerNumber), players.get(playerNumber).getPosition());
    }

    private void output(List<String> executeResult) {
        InputManager inputManager = new InputManager();
        OutputView.printNames(names);

        for (Line line : ladder.getLadder()) {
            OutputView.printLadder(line);
        }

        OutputView.printExecuteResult(executeResult);
        OutputView.printMatchedExecuteResult(players, inputManager.getPlayerForResult(names, InputView.getPlayerForResult()), executeResult);
    }

}
