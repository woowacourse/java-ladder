package ladder.controller;

import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    public static void main(String[] args) {
        String inputNames = InputView.inputNames();
        String[] names = splitNames(inputNames);

        int height = InputView.inputHeight();

        Ladder ladder = new Ladder(names, height);
        OutputView.printLadder(ladder);
    }

    public static String[] splitNames(String names) {
        return names.split(",");
    }
}
