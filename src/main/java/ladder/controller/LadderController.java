package ladder.controller;

import java.util.List;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.generator.RungGenerator;
import ladder.domain.player.Players;
import ladder.dto.response.LadderResponse;
import ladder.dto.response.PlayersResponse;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RungGenerator rungGenerator;

    public LadderController(InputView inputView, OutputView outputView, RungGenerator rungGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.rungGenerator = rungGenerator;
    }

    public void run() {
        Players players = initPlayers();
        LadderHeight ladderHeight = initLadderHeight();

        Ladder ladder = new Ladder(players.getSize(), ladderHeight, rungGenerator);

        printLadder(players, ladder);
    }

    public Players initPlayers() {
        List<String> playerNames = inputView.readPlayerNames();

        return new Players(playerNames);
    }

    public LadderHeight initLadderHeight() {
        int ladderHeight = inputView.readLadderHeight();

        return new LadderHeight(ladderHeight);
    }

    private void printLadder(Players players, Ladder ladder) {
        outputView.printLadderResultMessage();
        outputView.printPlayerNames(PlayersResponse.from(players));
        outputView.printLadder(LadderResponse.from(ladder));
    }
}
