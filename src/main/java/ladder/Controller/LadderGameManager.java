package ladder.Controller;

import ladder.View.OutputView;
import ladder.domain.*;
import ladder.View.InputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGameManager {
    private Map<Integer, Player> players;
    private List<Line> createdLadder;
    private List<String> names;

    public LadderGameManager() {
        players = new HashMap<>();
        createdLadder = new ArrayList<>();
        names = new ArrayList<>();
    }

    public void start() {
        InputModel inputModel = new InputModel();
        names = inputModel.getValidNames(InputView.getNames());
        List<String> executeResult = inputModel.getValidExecuteResult(InputView.getExecuteResult(), names.size());
        int ladderHeight = inputModel.getValidLadderHeight(InputView.getLadderHeight());
        createdLadder = new Ladder(names.size(), ladderHeight).getLadder();
        createPlayers();

        ladderMove(ladderHeight);
        output(inputModel,executeResult);
    }

    private void createPlayers() {
        for (int i = 0; i < names.size(); i++) {
            players.put(i, checkPlayers(i));
        }
    }

    private Player checkPlayers(int playerNumber) {
        if (playerNumber == 0) {
            return new Player(names.get(playerNumber), playerNumber, new Direction(false, createdLadder.get(0).getRowLines().get(playerNumber)));
        }
        if (playerNumber == names.size() - 1) {
            return new Player(names.get(playerNumber), playerNumber, new Direction(createdLadder.get(0).getRowLines().get(playerNumber - 1), false));
        }
        return new Player(names.get(playerNumber), playerNumber, new Direction(createdLadder.get(0).getRowLines().get(playerNumber - 1), createdLadder.get(0).getRowLines().get(playerNumber)));
    }

    private void ladderMove(int ladderHeight) {
        for (int i = 0; i < players.size(); i++) {
            moveLadderHeight(i, ladderHeight);
        }
    }

    private void moveLadderHeight(int playerNumber, int ladderHeight) {
        for (int j = 0; j < ladderHeight; j++) {
            players.get(playerNumber).move(players.size());
            if (j + 1 == ladderHeight) break;
            players.put(playerNumber, checkPlayerPosition(playerNumber, j + 1, players.get(playerNumber).getPosition()));
        }
    }

    private Player checkPlayerPosition(int playerNumber, int height, int playerPosition) {
        if (playerPosition == 0) {
            return new Player(names.get(playerNumber), players.get(playerNumber).getPosition(), new Direction(false, createdLadder.get(height).getRowLines().get(playerPosition)));
        }

        if (playerPosition == names.size() - 1) {
            return new Player(names.get(playerNumber), players.get(playerNumber).getPosition(), new Direction(createdLadder.get(height).getRowLines().get(playerPosition - 1), false));
        }

        return new Player(names.get(playerNumber), players.get(playerNumber).getPosition(), new Direction(createdLadder.get(height).getRowLines().get(playerPosition - 1), createdLadder.get(height).getRowLines().get(playerPosition)));
    }

    private void output(InputModel inputModel, List<String> executeResult) {
        OutputView.printNames(names);

        for (Line line : createdLadder) {
            OutputView.printLadder(line);
        }

        OutputView.printExecuteResult(executeResult);
        OutputView.printMatchedExecuteResult(players, inputModel.getPlayerForResult(names, InputView.getPlayerForResult()), executeResult);
    }

}
