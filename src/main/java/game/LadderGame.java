package game;

import domain.ladder.Ladder;
import domain.ladder.LadderHeight;
import domain.player.Name;
import domain.player.Players;
import domain.result.Result;
import domain.result.Results;
import java.util.List;
import java.util.function.BooleanSupplier;
import view.InputView;
import view.OutputView;

public class LadderGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanSupplier patternCreationStrategy;

    public LadderGame(InputView inputView, OutputView outputView, BooleanSupplier patternCreationStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.patternCreationStrategy = patternCreationStrategy;
    }

    public void play() {
        Players players = getNames();
        LadderHeight height = getHeight();
        Results results = getResults();

        Ladder ladder = new Ladder(players.size(), results.size(), height);
        ladder.drawLines(patternCreationStrategy);

        printLadder(ladder, players, results);

        String playerName = getPlayerName();
        printLadderResult(ladder, players, results, playerName);
    }

    private Players getNames() {
        outputView.printReadNames();
        List<String> names = inputView.readTokens();
        return new Players(names);
    }

    private Results getResults() {
        outputView.printReadResults();
        List<String> results = inputView.readTokens();
        return new Results(results);
    }

    private LadderHeight getHeight() {
        outputView.printReadLadderHeight();
        int height = inputView.readLadderHeight();
        return new LadderHeight(height);
    }

    private String getPlayerName() {
        outputView.printReadNameForResult();
        return inputView.readToken();
    }

    private void printLadder(Ladder ladder, Players players, Results results) {
        outputView.printLadderCreationMessage();
        outputView.printTokens(players.getRawNames());
        outputView.printLadder(ladder.getLadderPatterns());
        outputView.printTokens(results.getRawResults());
    }

    private void printLadderResult(Ladder ladder, Players players, Results results, String playerName) {
        outputView.printResultMessage();
        List<Integer> mappedIndices = ladder.getMappedIndices();
        if (playerName.equals("all")) {
            printAllResults(mappedIndices, players, results);
            return;
        }
        printSingleResult(mappedIndices, players, results, playerName);
    }

    private void printAllResults(List<Integer> ladderResults, Players players, Results results) {
        for (int index = 0; index < players.size(); index++) {
            Name name = players.get(index);
            Result result = results.get(ladderResults.get(index));
            outputView.printPlayerResult(name.rawName(), result.rawResult());
        }
    }

    private void printSingleResult(List<Integer> ladderResults,
                                   Players players,
                                   Results results,
                                   String playerName) {
        int playerIndex = players.getIndexByName(playerName);
        Result result = results.get(ladderResults.get(playerIndex));
        outputView.printToken(result.rawResult());
    }
}
