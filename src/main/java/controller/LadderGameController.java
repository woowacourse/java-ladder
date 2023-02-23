package controller;

import model.domain.Ladder;
import model.VO.LadderHeight;
import model.domain.Line;
import model.VO.Name;
import model.domain.Players;
import model.VO.Result;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

public class LadderGameController {
    public InputView inputView;
    public OutputView outputView;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Players players = new Players(setPlayerNames());
        List<Result> results = setResults(players.size());
        Ladder ladder = new Ladder(players, setLadderHeight());
        showCreateLadderResult(players, results, ladder);
        playGame(players, ladder, results);
        showGameResult(players);
    }

    private void showCreateLadderResult(Players players, List<Result> results, Ladder ladder) {
        outputView.printMakeLadderResultMessage();
        outputView.printAllPlayerNames(players.getAllPlayerNames());
        outputView.printLadder(ladder);
        outputView.printAllResults(results);
    }

    private void showGameResult(Players players) {
        Name name = getDesirousResultName();
        repeatShowResultUntilInputAll(players, name);
        showAllResults(players);
    }

    private void repeatShowResultUntilInputAll(Players players, Name name) {
        Name all = new Name("all");
        while (!name.isSame(all)) {
            outputView.printResultHeaderMessage();
            outputView.printResult(players.getResultOf(name));
            name = getDesirousResultName();
        }
    }

    private void showAllResults(Players players) {
        outputView.printResultHeaderMessage();
        players.getAllPlayerNames().forEach(name -> outputView.printNameAndResult(name, players.getResultOf(name)));
    }

    private Name getDesirousResultName() {
        outputView.printDesirousResultNameMessage();
        return inputView.readDesirousResultName();
    }

    private void playGame(Players players, Ladder ladder, List<Result> results) {
        IntStream.range(0, ladder.getHeight())
                .forEach(index -> playOneLine(players, ladder.getLine(index)));
        players.saveAllResults(results);
    }

    private void playOneLine(Players players, Line line) {
        players.moveAllPlayersByLinePoints(line.getPoints());
    }

    private List<Result> setResults(int playerCount) {
        outputView.printResultsMessage();
        return inputView.readResults(playerCount);
    }

    private List<Name> setPlayerNames() {
        outputView.printPlayerNamesMessage();
        return inputView.readPlayerNames();
    }

    private LadderHeight setLadderHeight() {
        outputView.printLadderHeightMessage();
        return inputView.readLadderHeight();
    }
}
