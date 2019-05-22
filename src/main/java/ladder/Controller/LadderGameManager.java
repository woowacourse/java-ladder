package ladder.Controller;

import ladder.View.InputView;
import ladder.View.OutputView;
import ladder.domain.*;

import java.util.ArrayList;
import java.util.List;

public class LadderGameManager {
    private List<Player> players;
    private List<String> names;
    private Ladder ladder;

    public LadderGameManager() {
        players = new ArrayList<>();
        names = new ArrayList<>();
    }

    public void start() {
        InputManager inputManager = new InputManager();
        names = inputManager.getValidNames(InputView.getNames());
        List<String> executeResult = inputManager.getValidExecuteResult(InputView.getExecuteResult(), names.size());
        int ladderHeight = inputManager.getValidLadderHeight(InputView.getLadderHeight());

        ladder = new Ladder(names.size(), ladderHeight);
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
        int playerNumber = 0;
        for (Player player : players) {
            moveLadderHeight(playerNumber, player, ladderHeight);
            playerNumber++;
        }
    }

    private void moveLadderHeight(int playerNumber, Player player, int ladderHeight) {
        for (int j = 0; j < ladderHeight; j++) {
            player.move(players.size(), checkPlayerDirection(j, player.getPosition()));
            players.set(playerNumber, getPlayer(player));
        }
    }

    private Direction checkPlayerDirection(int height, int playerPosition) {
        return ladder.CurrentDirection(height, playerPosition);
    }

    private Player getPlayer(Player player) {
        return new Player(player.getName(), player.getPosition());
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
