import java.util.List;
import java.util.Map;

import domain.Ladder;
import domain.LadderGame;
import domain.Names;
import domain.Results;
import view.InputView;
import view.OutputView;

public class Application {

    private static final String EXIT_FLAG = "all";

    public static void main(final String[] args) {
        Names names = receiveNames();
        Results results = receiveResults(names.getNames().size());

        LadderGame ladderGame = new LadderGame(names, results);
        Ladder ladder = ladderGame.createLadder(receiveHeight());

        OutputView.printLadder(ladderGame.getNames(), ladder, ladderGame.getResults());
        showResults(ladderGame.createResult(ladder));
    }

    private static Names receiveNames() {
        try {
            List<String> names = InputView.readNames();
            return new Names(names);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return receiveNames();
        }
    }

    private static Results receiveResults(final int numberOfName) {
        try {
            String results = InputView.readResults();
            return new Results(results, numberOfName);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return receiveResults(numberOfName);
        }
    }

    private static int receiveHeight() {
        try {
            return InputView.readHeight();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return receiveHeight();
        }
    }

    private static void showResults(final Map<String, String> gameResult) {
        String inputName = "";
        do {
            inputName = receiveNameToShowResult(inputName, gameResult);
        } while (!inputName.equals(EXIT_FLAG));
    }

    private static String receiveNameToShowResult(String inputName, final Map<String, String> gameResult) {
        try {
            inputName = InputView.readNameToShowResult();
            OutputView.printResult(inputName, gameResult);
            return inputName;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return receiveNameToShowResult(inputName, gameResult);
        }
    }
}
