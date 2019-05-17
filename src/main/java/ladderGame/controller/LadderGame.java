package ladderGame.controller;

import ladderGame.dto.DrawnLadder;
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
        DrawnLadder drawnLadder = generateDrawnLadder(playerNamesInput, rows);
        OutputView.printLadder(drawnLadder, playerNamesInput.getNames(), resultsInput.getResults());

        showResultUntilUserQuits(drawnLadder, playerNamesInput, resultsInput);
    }

    private static DrawnLadder generateDrawnLadder(PlayerNamesInput playerNamesInput, int rows) {
        LadderFactory ladderFactory = new LadderFactory(new LadderRowFactory());
        Ladder ladder = ladderFactory.newInstance(rows, playerNamesInput.getNames().size() - 1 );
        LadderDrawer ladderDrawer = new LadderDrawer();
        ladderDrawer.draw(ladder, rows);
        return ladder.drawn();
    }

    private static String showResultUntilUserQuits(DrawnLadder drawnLadder,
                                                   PlayerNamesInput playerNamesInput,
                                                   ResultsInput resultsInput) {
        String name = InputView.readPlayer(playerNamesInput);
        if (name.equals("all")) {
            OutputView.printAllResults(drawnLadder, playerNamesInput, resultsInput);
        }
        if (name.equals("quit")) {
            return name;
        }
        if (playerNamesInput.getNames().contains(name)) {
            OutputView.printOnePlayerResult(drawnLadder, name, playerNamesInput, resultsInput);
        }
        return showResultUntilUserQuits(drawnLadder, playerNamesInput, resultsInput);
    }
}


