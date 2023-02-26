package controller;

import domain.Height;
import domain.Ladder;
import domain.LadderGame;
import domain.Line;
import domain.LineMaker;
import domain.LineStatus;
import domain.Lines;
import domain.Players;
import domain.Results;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import generator.LineGenerator;
import domain.PlayersMaker;
import generator.RandomLineGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {

    private static final String DELIMITER_WITH_BLANK = "\\s*,\\s*";

    public void run() {
        Players players = makePlayers();
        Results results = makeResult(players.getNumberOfPlayers());
        Height height = new Height(inputHeight());
        Ladder ladder = makeLadder(height, players.getNumberOfPlayers());

        LadderGame ladderGame = playLadderGame(players, results, ladder);
        getResult(players, ladderGame);
    }

    private Players makePlayers() {
        try {
            String playersName = inputPlayers();
            return PlayersMaker.makePlayers(playersName);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return makePlayers();
        }
    }

    private String inputPlayers() {
        try{
            return InputView.receivePlayer();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return inputPlayers();
        }
    }

    private Results makeResult(int playerCount) {
        try{
            String results = inputResults();
            return new Results(makeResults(results), playerCount);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return makeResult(playerCount);
        }
    }

    private String inputResults() {
        try{
            return InputView.receiveResults();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return inputResults();
        }
    }

    private int inputHeight() {
        try {
            return InputView.receiveHeight();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return inputHeight();
        }
    }

    private List<String> makeResults(String results) {
        return List.of(results.split(DELIMITER_WITH_BLANK));
    }

    private Ladder makeLadder(Height height, int numberOfWalls) {
        LineGenerator lineGenerator = new RandomLineGenerator();
        Lines lines = makeLines(height, numberOfWalls, lineGenerator);

        return new Ladder(lines, height);
    }

    private Lines makeLines(Height height, int numberOfWalls, LineGenerator lineGenerator) {
        List<Line> lines = new ArrayList<>();
        int numberOfLine = numberOfWalls - 1;

        for (int i = 0; i < height.getHeight(); i++) {
            LineMaker lineMaker = new LineMaker(lineGenerator);
            List<LineStatus> lineStatuses = lineMaker.makeLineStatus(numberOfLine);
            lines.add(new Line(lineStatuses));
        }

        return new Lines(lines);
    }

    private LadderGame playLadderGame(Players players, Results results, Ladder ladder) {
        LadderGame ladderGame = new LadderGame(players, ladder, results);

        ladderGame.printLadder();
        ladderGame.playGame();

        return ladderGame;
    }

    private void getResult(Players players, LadderGame ladderGame) {
        Map<String, String> ladderGameResult = ladderGame.getLadderGameResult();
        String playerNameWantToSeeResult = inputPlayerNameWantToSeeResult(players);
        OutputView.printResult(ladderGameResult, players, playerNameWantToSeeResult);
    }

    private String inputPlayerNameWantToSeeResult(Players players) {
        try {
            String playerName = InputView.receivePlayerName();
            players.validateExistPlayer(playerName);
            return playerName;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return inputPlayerNameWantToSeeResult(players);
        }
    }
}
