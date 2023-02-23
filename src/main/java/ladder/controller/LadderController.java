package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.PlayerResult;
import ladder.domain.PlayerResults;
import ladder.domain.Players;
import ladder.domain.Prizes;
import ladder.dto.LadderResponse;
import ladder.dto.PlayerResultsResponse;
import ladder.dto.PlayersResponse;
import ladder.dto.PrizesResponse;
import ladder.service.LadderService;
import ladder.view.LadderView;

public class LadderController {
    private static final String EXIT_COMMAND = "all";

    private final LadderService ladderService;
    private final LadderView ladderView;

    public LadderController(LadderService ladderService, LadderView ladderView) {
        this.ladderService = ladderService;
        this.ladderView = ladderView;
    }

    public void run() {
        PlayerResults playerResults = createPlayerResults();
        printPlayerResult(playerResults);
        ladderView.printAllPlayerResults(PlayerResultsResponse.of(playerResults));
    }

    private PlayerResults createPlayerResults() {
        String inputNames = ladderView.readPlayerNames();
        int inputHeight = ladderView.readLadderHeight();
        String resultsInput = ladderView.readPrizes();
        Players players = ladderService.createPlayers(inputNames);
        Height height = new Height(inputHeight);
        Prizes prizes = ladderService.createPrizes(resultsInput, players);
        Ladder ladder = ladderService.createLadder(height, players);
        ladderView.printLadderResult(PlayersResponse.ofPlayers(players), LadderResponse.ofLadder(ladder),
                PrizesResponse.ofResults(prizes));
        return ladderService.createPlayerResults(players, ladder, prizes);
    }

    private void printPlayerResult(PlayerResults playerResults) {
        String playerName = ladderView.readPlayerName();
        if (playerName.equals(EXIT_COMMAND)) {
            return;
        }
        PlayerResult playerResult = playerResults.findByPlayerName(playerName);
        ladderView.printResult(playerResult.getPrize());
        printPlayerResult(playerResults);
    }
}
