package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.LadderGameResult;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private static final String SPLIT_SEPARATOR = ",";

    public static void main(String[] args) {
        String inputNames = InputView.inputNames();
        String[] names = splitNames(inputNames);
        String inputPrizes = InputView.inputPrize();
        String[] prizes = splitNames(inputPrizes);
        int height = InputView.inputHeight();


        Ladder ladder = new Ladder(names.length, height);
        LadderGame ladderGame = new LadderGame(ladder, names, prizes);
        OutputView.printLadderGame(ladderGame);
        LadderGameResult ladderGameResult = ladderGame.start();
        String inputNameForResult;
        do{
            inputNameForResult = InputView.inputNameForResult();
            OutputView.printLadderGameResult(ladderGameResult, inputNameForResult);
        } while(!inputNameForResult.equals(OutputView.ALL_USER));

    }

    public static String[] splitNames(String names) {
        return names.split(SPLIT_SEPARATOR);
    }
}
