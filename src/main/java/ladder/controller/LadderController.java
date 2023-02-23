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
        Players players = ladderService.createPlayers(ladderView.readPlayerNames());
        Height height = new Height(ladderView.readLadderHeight());
        Prizes prizes = ladderService.createPrizes(ladderView.readPrizes(), players);
        Ladder ladder = ladderService.createLadder(height, players);
        ladderView.printLadderResult(PlayersResponse.ofPlayers(players), LadderResponse.ofLadder(ladder),
                PrizesResponse.ofPrizes(prizes));
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
