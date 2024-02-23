package ladder.controller;

import java.util.List;
import java.util.function.Supplier;
import ladder.domain.LadderGame;
import ladder.domain.Prizes;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.generator.RungGenerator;
import ladder.domain.player.Player;
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
        Players players = retryOnException(this::initPlayers);
        Prizes prizes = retryOnException(() -> initPrizes(players.getSize()));
        LadderHeight ladderHeight = retryOnException(this::initLadderHeight);

        Ladder ladder = new Ladder(players.getSize(), ladderHeight, rungGenerator);
        LadderGame ladderGame = new LadderGame(players, ladder, prizes);

        printLadder(players, ladder);
    }

    public Players initPlayers() {
        List<String> playerNames = inputView.readPlayerNames();

        return new Players(playerNames);
    }

    public Prizes initPrizes(int playersSize) {
        List<String> prizes = inputView.readPrizes();

        validatePrizesSize(playersSize, prizes.size());

        return new Prizes(prizes);
    }

    private static void validatePrizesSize(int playersSize, int prizesSize) {
        if (playersSize != prizesSize) {
            throw new IllegalArgumentException("참여하는 사람 수와 상품의 개수가 일치하지 않습니다.");
        }
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
