package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Player;
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
    private final LadderService ladderService;
    private final LadderView ladderView;

    public LadderController(LadderService ladderService, LadderView ladderView) {
        this.ladderService = ladderService;
        this.ladderView = ladderView;
    }

    public void run() {
        String inputNames = ladderView.readPlayerNames();
        int inputHeight = ladderView.readLadderHeight();
        String resultsInput = ladderView.readPrizes();
        Players players = ladderService.createPlayers(inputNames);
        Height height = new Height(inputHeight);
        Prizes prizes = ladderService.createPrizes(resultsInput, players);
        Ladder ladder = ladderService.createLadder(height, players.getPlayersCount());
        ladderView.printLadderResult(PlayersResponse.ofPlayers(players), LadderResponse.ofLadder(ladder),
                PrizesResponse.ofResults(prizes));
        PlayerResults playerResults = ladderService.createPlayerResults(players, ladder, prizes);
        while (true) {
            String playerName = ladderView.readPlayerName();
            if (playerName.equals("all")) {
                break;
            }
            PlayerResult playerResult = playerResults.findByPlayerName(playerName);
            ladderView.printResult(playerResult.getPrize());
        }
        ladderView.printAllPlayerResults(PlayerResultsResponse.of(playerResults));
    }
}
