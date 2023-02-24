package laddergame.controller;

import laddergame.ladder.Ladder;
import laddergame.ladder.LadderGenerator;
import laddergame.ladder.LadderHeight;
import laddergame.ladder.LadderWidth;
import laddergame.player.Player;
import laddergame.player.Players;
import laddergame.result.GameResult;
import laddergame.result.GameResultViewScope;
import laddergame.result.Prizes;
import laddergame.view.InputView;
import laddergame.view.ResultView;
import laddergame.vo.Position;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LadderGameController {
    private final InputView inputView;
    private final ResultView resultView;
    private final LadderGenerator ladderGenerator;

    public LadderGameController(InputView inputView, ResultView resultView, LadderGenerator ladderGenerator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.ladderGenerator = ladderGenerator;
    }

    public void run() {
        Players players = readPlayers();
        Prizes prizes = readGamePrizes(players.getCount());

        Ladder ladder = makeLadder(players);

        printLadderInformation(players, ladder, prizes);
        GameResult gameResult = runLadderGame(players, ladder, prizes);
        checkGameResult(gameResult);
    }

    private Players readPlayers() {
        List<String> participantNames = inputView.readParticipantNames();
        return Players.from(participantNames);
    }

    private Prizes readGamePrizes(int prizeCount) {
        List<String> prizeNames = inputView.readGameResults();
        return Prizes.from(prizeNames, prizeCount);
    }

    private Ladder makeLadder(Players players) {
        LadderHeight height = new LadderHeight(inputView.readLadderHeight());
        LadderWidth width = new LadderWidth(players.getCount() - 1);
        return ladderGenerator.generate(width, height);
    }

    private void printLadderInformation(Players players, Ladder ladder, Prizes prizes) {
        resultView.printLadderInformationTitle();
        resultView.printPlayersName(players.getNames());
        resultView.printLadder(ladder.getFootholdsMap());
        resultView.printPrizes(prizes.getPrizeNames());
    }

    private GameResult runLadderGame(Players players, Ladder ladder, Prizes prizes) {
        Map<Player, Position> playerPositions = players.climbDownLadder(ladder);
        return GameResult.of(playerPositions, prizes);
    }

    private void checkGameResult(GameResult gameResult) {
        String scopeOrName = inputView.readScopeOfResultChecking();
        Optional<GameResultViewScope> scope = GameResultViewScope.from(scopeOrName);

        while (isScopeOnePerson(scope)) {
            String result = gameResult.fetchResultByName(scopeOrName);
            resultView.printResultOfOnePerson(result);
            scopeOrName = inputView.readScopeOfResultChecking();
            scope = GameResultViewScope.from(scopeOrName);
        }
        resultView.printResultOfAll(gameResult.fetchAllResults());
    }

    private boolean isScopeOnePerson(Optional<GameResultViewScope> scope) {
        return scope.isEmpty();
    }
}
