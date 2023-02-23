package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.domain.PlayerResult;
import ladder.domain.PlayerResults;
import ladder.domain.Players;
import ladder.domain.Results;
import ladder.dto.LadderResponse;
import ladder.dto.PlayerResultsResponse;
import ladder.dto.PlayersResponse;
import ladder.dto.ResultsResponse;
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
        String resultsInput = ladderView.readResults();
        Players players = ladderService.createPlayers(inputNames);
        Height height = new Height(inputHeight);
        Results results = ladderService.createResults(resultsInput, players.getPlayersCount());
        Ladder ladder = ladderService.createLadder(height, players.getPlayersCount());
        ladderView.printLadderResult(PlayersResponse.ofPlayers(players), LadderResponse.ofLadder(ladder),
                ResultsResponse.ofResults(results));
        PlayerResults playerResults = ladderService.createPlayerResults(players, ladder, results);
        while (true) {
            String playerName = ladderView.readPlayerName();
            if (playerName.equals("all")) {
                break;
            }
            Player player = players.findByPlayerName(playerName);
            PlayerResult playerResult = playerResults.findByPlayer(player);
            ladderView.printResult(playerResult.getResult());
        }
        ladderView.printAllPlayerResults(PlayerResultsResponse.of(playerResults));
    }
}
