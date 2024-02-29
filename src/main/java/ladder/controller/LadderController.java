package ladder.controller;

import java.util.Map;
import ladder.dto.LineDto;
import ladder.model.Ladder;
import ladder.model.Players;
import ladder.service.LadderGame;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderController {
    private Players ladderPlayers;
    private Ladder ladder;

    private LadderGame ladderGame;

    public void start() {
        init();
        printResult();
    }

    private void init() {
        ladderPlayers = Players.from(readPlayerNames());

        int height = readLadderHeight();
        int width = ladderPlayers.getSize();
        ladder = Ladder.of(height, width);
        ladderGame = LadderGame.from(ladderPlayers, readRewards(), ladder);

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

    private void printResult() {
        OutputView.printResultDescription();
        OutputView.printPlayerNames(ladderPlayers.getPlayerNames());

        List<LineDto> lineDtos = ladder.getLadder().stream()
                .map(LineDto::from)
                .toList();
        OutputView.printLadder(lineDtos);

        Map<String, String> ladderResult = ladderGame.play();

        System.out.println(ladderResult);
    }
}
