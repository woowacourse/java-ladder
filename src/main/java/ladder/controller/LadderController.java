package ladder.controller;

import java.util.function.Supplier;
import ladder.domain.LadderGame;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.generator.RungGenerator;
import ladder.domain.player.Players;
import ladder.domain.prize.Prizes;
import ladder.dto.response.ladder.LadderResponse;
import ladder.dto.response.player.PlayersResponse;
import ladder.dto.response.prize.PrizesResponse;
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
        Players players = retryOnException(() -> Players.from(inputView.readPlayerNames()));
        Prizes prizes = retryOnException(() -> Prizes.of(inputView.readPrizes(), players.size()));
        Ladder ladder = retryOnException(() -> Ladder.of(inputView.readLadderHeight(), players.size(), rungGenerator));

        LadderGame ladderGame = LadderGame.of(players, ladder, prizes);

        printLadder(players, ladder, prizes);
    }

    private void printLadder(Players players, Ladder ladder, Prizes prizes) {
        PlayersResponse playersResponse = PlayersResponse.from(players);
        LadderResponse ladderResponse = LadderResponse.from(ladder);
        PrizesResponse prizesResponse = PrizesResponse.from(prizes);

        outputView.printLadderGame(playersResponse, ladderResponse, prizesResponse);
    }

    private <T> T retryOnException(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
