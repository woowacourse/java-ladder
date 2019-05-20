package ladderGame.controller;
import ladderGame.model.input.PlayerNamesInput;
import ladderGame.model.input.ResultsInput;
import ladderGame.model.ladder.*;
import ladderGame.view.InputView;
import ladderGame.view.OutputView;


public class LadderGame {

    public static void main(String[] args) {
        PlayerNamesInput playerNamesInput = InputView.readNames();
        int rows = InputView.readRows();
        ResultsInput resultsInput = InputView.readResults(playerNamesInput);

        int columns = playerNamesInput.getNames().size() - 1;
        LadderFactory ladderFactory = new LadderFactory();
        Ladder ladder = ladderFactory.generateLadder(rows, columns);

        OutputView.printLadder(ladder, playerNamesInput.getNames(), resultsInput.getResults());
        showResultUntilUserQuits(ladder, playerNamesInput, resultsInput);
    }

    private static String showResultUntilUserQuits(Ladder ladder,
                                                   PlayerNamesInput playerNamesInput,
                                                   ResultsInput resultsInput) {
        String name = InputView.readPlayer(playerNamesInput);
        if (name.equals("all")) {
            OutputView.printAllResults(ladder, playerNamesInput, resultsInput);
        }
        if (name.equals("quit")) {
            return name;
        }
        if (playerNamesInput.getNames().contains(name)) {
            OutputView.printOnePlayerResult(ladder, name, playerNamesInput, resultsInput);
        }
        return showResultUntilUserQuits(ladder, playerNamesInput, resultsInput);
    }
}

