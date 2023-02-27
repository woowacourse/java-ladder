package ladder.controller;

import ladder.domain.GameResults;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.RandomBarGenerator;
import ladder.domain.ladder.Results;
import ladder.domain.people.Names;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.HashMap;
import java.util.List;

public class LadderController {

    public void run() {
        Names names = InputView.repeat(() -> new Names(InputView.inputPeopleNames()));
        List<String> namesList = names.getNames();

        Results results = InputView.repeat(() -> new Results(InputView.inputResults(), namesList.size()));
        List<String> resultsList = results.getResults();

        int ladderHeight = InputView.repeat(InputView::inputLadderHeight);
        Ladder ladder = new Ladder(new RandomBarGenerator(), ladderHeight, namesList.size());
        GameResults gameResults = new GameResults(namesList, resultsList, ladder);

        OutputView.printLadderResultMessage();
        printLadder(ladder, namesList, resultsList);
        viewGameResults(gameResults.calculateGameResults(), namesList);
    }

    private void printLadder(Ladder ladder, List<String> namesList, List<String> resultsList) {
        OutputView.printInputString(namesList);
        OutputView.printLadder(ladder, namesList.get(0).length());
        OutputView.printInputString(resultsList);
    }

    private void viewGameResults(HashMap<String, String> gameResults, List<String> namesList) {
        String name = InputView.repeat(() -> InputView.inputWantGameResults(namesList));
        if ("all" .equals(name)) {
            printGameResultsAll(gameResults);
            return;
        }

        printGameResultsUnique(gameResults, name);
        viewGameResults(gameResults, namesList);
    }

    private void printGameResultsAll(HashMap<String, String> gameResults) {
        OutputView.printGameResultsAll(gameResults);
    }

    private void printGameResultsUnique(HashMap<String, String> gameResults, String name) {
        OutputView.printGameResultsUnique(gameResults, name);
    }
}
