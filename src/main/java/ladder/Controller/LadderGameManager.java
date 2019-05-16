package ladder.Controller;

import ladder.View.OutputView;
import ladder.domain.InputModel;
import ladder.View.InputView;
import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.ArrayList;
import java.util.List;

public class LadderGameManager {
    private List<String> players;
    private List<Line> createdLadder;

    public LadderGameManager() {
        players = new ArrayList<>();
        createdLadder = new ArrayList<>();
    }

    public void start() {
        InputModel inputModel = new InputModel();
        players = inputModel.getValidNames(InputView.getNames());
        int ladderHeight = inputModel.getValidLadderHeight(InputView.getLadderHeight());

        Ladder ladder = new Ladder(players.size(), ladderHeight);
        createdLadder = ladder.getLadder();

        output();
    }

    private void output() {
        OutputView.printResult(players);
        for ( Line line : createdLadder) {
            OutputView.printLadder(line);
        }
    }
}
