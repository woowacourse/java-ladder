package ladder.controller;

import ladder.domain.GameResults;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.RandomBarGenerator;
import ladder.domain.ladder.Results;
import ladder.domain.people.Names;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.Map;

public class LadderController {

    public void run() {
        List<String> namesList = (InputView.repeat(() -> new Names(InputView.inputPeopleNames()))).getNames();

        List<String> resultsList = (InputView.repeat(() -> new Results(InputView.inputResults(), namesList.size()))).getResults();

        Ladder ladder = new Ladder(new RandomBarGenerator(), InputView.repeat(InputView::inputLadderHeight), namesList.size());
        GameResults gameResults = new GameResults(namesList, resultsList, ladder);

        OutputView.printLadderResultMessage();
        printLadder(ladder, namesList, resultsList);
        viewGameResults(gameResults.calculateGameResults(), namesList);
    }

    private void printLadder(Ladder ladder, List<String> namesList, List<String> resultsList) {
        OutputView.printInputString(namesList);
        OutputView.printLadder(ladder);
        OutputView.printInputString(resultsList);
    }

    private void viewGameResults(Map<String, String> gameResults, List<String> namesList) {
        String name = InputView.repeat(() -> InputView.inputWantGameResults(namesList));
        if ("all" .equals(name)) {
            printGameResultsAll(gameResults);
            return;
        }

        printGameResultsUnique(gameResults, name);
        viewGameResults(gameResults, namesList);
    }

    private void printGameResultsAll(Map<String, String> gameResults) {
        OutputView.printGameResultsAll(gameResults);
    }

    private void printGameResultsUnique(Map<String, String> gameResults, String name) {
        OutputView.printGameResultsUnique(gameResults, name);
    }
}
