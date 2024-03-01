package ladder.controller;

import ladder.dto.LineDto;
import ladder.model.Ladder;
import ladder.model.Players;
import ladder.service.LadderGame;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderController {
    private Ladder ladder;
    private LadderGame ladderGame;

    public void start() {
        init();
        printResult();
    }

    private void init() {
        Players ladderPlayers = Players.from(readPlayerNames());

        int height = readLadderHeight();
        int width = ladderPlayers.getSize();

        List<String> rewards = readRewards();

        ladder = Ladder.of(height, width);
        ladderGame = LadderGame.from(ladderPlayers, rewards, ladder);
    }

    private List<String> readPlayerNames() {
        return InputView.inputPlayerNames();
    }

    private int readLadderHeight() {
        return InputView.inputLadderHeight();
    }

    private List<String> readRewards() {
        return InputView.inputRewards();
    }

    private String readLookupTarget() {
        return InputView.inputLookupTarget();
    }

    private void printResult() {
        OutputView.printResultDescription();
        OutputView.printPlayerNames(ladderGame.getPlayerNames());

        List<LineDto> lineDtos = ladder.getLadder().stream()
                .map(LineDto::from)
                .toList();
        OutputView.printLadder(lineDtos);
        OutputView.printRewards(ladderGame.getRewards());

        OutputView.printGameResult(ladderGame.play());

    }
}
