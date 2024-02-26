package ladder.controller;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import ladder.domain.LadderGame;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.generator.RungGenerator;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;
import ladder.dto.response.LadderAllResultsResponse;
import ladder.dto.response.ladder.LadderResponse;
import ladder.dto.response.player.PlayersResponse;
import ladder.dto.response.prize.PrizeResponse;
import ladder.dto.response.prize.PrizesResponse;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    public static final String ALL_PLAYERS = "all";

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
        int playerCount = players.size();

        Prizes prizes = retryOnException(() -> initPrizes(playerCount));
        Ladder ladder = retryOnException(() -> initLadder(playerCount));

        LadderGame ladderGame = LadderGame.of(players, ladder, prizes);

        printLadderResult(players, ladder, prizes);
        printResultForSelectedPlayer(ladderGame);
    }

    private Players initPlayers() {
        List<String> playerNames = inputView.readPlayerNames();

        return Players.from(playerNames);
    }

    private Prizes initPrizes(int playerCount) {
        List<String> prizeNames = inputView.readPrizeNames();

        validatePrizeCount(playerCount, prizeNames.size());

        return Prizes.from(prizeNames);
    }

    private static void validatePrizeCount(int playerCount, int prizeCount) {
        if (prizeCount != playerCount) {
            throw new IllegalArgumentException("참여자 수와 상품 수가 일치하지 않습니다.");
        }
    }

    private Ladder initLadder(int playerCount) {
        int height = inputView.readLadderHeight();

        return Ladder.of(height, playerCount, rungGenerator);
    }

    private void printLadderResult(Players players, Ladder ladder, Prizes prizes) {
        PlayersResponse playersResponse = PlayersResponse.from(players);
        LadderResponse ladderResponse = LadderResponse.from(ladder);
        PrizesResponse prizesResponse = PrizesResponse.from(prizes);

        outputView.printLadderResult(playersResponse, ladderResponse, prizesResponse);
    }

    private void printResultForSelectedPlayer(LadderGame ladderGame) {
        String selectedPlayerName = inputView.readSelectedPlayerName();

        if (ALL_PLAYERS.equals(selectedPlayerName)) {
            printAllResults(ladderGame);
            return;
        }

        printPrizeForSelectedPlayer(ladderGame, selectedPlayerName);
        printResultForSelectedPlayer(ladderGame);
    }

    private void printAllResults(LadderGame ladderGame) {
        Map<Player, Prize> allResults = ladderGame.getAllResults();

        outputView.printAllResults(LadderAllResultsResponse.from(allResults));
    }

    private void printPrizeForSelectedPlayer(LadderGame ladderGame, String selectedPlayerName) {
        try {
            Prize prize = ladderGame.getResultByPlayerName(selectedPlayerName);

            outputView.printPrizeForSelectedPlayer(PrizeResponse.from(prize));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
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
