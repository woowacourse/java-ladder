package ladder.Controller;

import jdk.internal.util.xml.impl.Input;
import ladder.View.OutputView;
import ladder.domain.*;
import ladder.View.InputView;

import java.util.ArrayList;
import java.util.List;

public class LadderGameManager {
    private List<Player> players;
    private List<Line> createdLadder;

    public LadderGameManager() {
        players = new ArrayList<>();
        createdLadder = new ArrayList<>();
    }

    public void start() {
        InputModel inputModel = new InputModel();
        List<String> names = inputModel.getValidNames(InputView.getNames());

        PlayerManager playerManager = new PlayerManager(names);
        players = playerManager.getPlayers();

        int ladderHeight = inputModel.getValidLadderHeight(InputView.getLadderHeight());

        Ladder ladder = new Ladder(names.size(), ladderHeight);
        createdLadder = ladder.getLadder();

        output();
    }

    private void output() {
        OutputView.printLadderResult(players);
        for ( Line line : createdLadder) {
            OutputView.printLadder(line);
        }
    }
}
