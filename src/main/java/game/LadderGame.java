package game;

import java.util.List;
import java.util.function.BooleanSupplier;
import ladder.Ladder;
import ladder.Line;
import player.Players;
import result.Results;
import view.InputView;
import view.LadderUnit;
import view.OutputView;

public class LadderGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanSupplier connectionAttemptSupplier;

    public LadderGame(InputView inputView, OutputView outputView, BooleanSupplier connectionAttemptSupplier) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.connectionAttemptSupplier = connectionAttemptSupplier;
    }

    public void play() {
        Players players = getPlayers();
        int height = getHeight();
        Results results = getResults();
        validateSize(players, results);

        Ladder ladder = new Ladder(players.size(), height, connectionAttemptSupplier);
        printLadder(ladder, players, results);

        String command = getCommand();
        outputView.printResultMessage();
        printLadderResults(ladder, players, results, command);
    }

    private void validateSize(Players players, Results results) {
        if (players.size() != results.size()) {
            throw new IllegalArgumentException("참가자 수와 결과 수가 다릅니다.");
        }
    }

    private void printLadderResults(Ladder ladder, Players players, Results results, String command) {
        if (Command.ALL.isSameCommand(command)) {
            printAllResults(ladder, players, results);
            return;
        }
        printSingleResult(players, command, results);
    }

    private void printLadder(Ladder ladder, Players players, Results results) {
        outputView.printLadderCreationMessage();
        outputView.printTokens(players.getNames());

        for (Line line : ladder.getLines()) {
            List<LadderUnit> ladderUnits = line.getDirections().stream()
                    .map(LadderUnit::fromDirection)
                    .toList();
            outputView.printLadderUnits(ladderUnits);
        }
        outputView.printTokens(results.getNames());
    }

    private void printSingleResult(Players players, String command, Results results) {
        int index = players.findIndexByName(command);
        String result = results.getNameByIndex(index);
        outputView.printPlayerResult(command, result);
    }

    private void printAllResults(Ladder ladder, Players players, Results results) {
        for (int index = 0; index < players.size(); index++) {
            String name = players.getNameByIndex(index);
            int resultIndex = ladder.climbDown(index);
            outputView.printPlayerResult(name, results.getNameByIndex(resultIndex));
        }
    }

    private Players getPlayers() {
        outputView.printReadNames();
        List<String> nameTokens = inputView.readTokens();
        return new Players(nameTokens);
    }

    private Results getResults() {
        outputView.printReadResults();
        List<String> resultTokens = inputView.readTokens();
        return new Results(resultTokens);
    }

    private int getHeight() {
        outputView.printReadLadderHeight();
        return inputView.readLadderHeight();
    }

    private String getCommand() {
        outputView.printReadNameForResult();
        return inputView.readToken();
    }
}
