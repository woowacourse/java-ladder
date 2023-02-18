package ladder.view;

import java.util.List;

public class LadderView {
    public String[] readPlayerNames() {
        return InputView.readPlayerNames();
    }

    public int readLadderHeight() {
        return InputView.readLadderHeight();
    }

    public void printResult(String names, List<String> lines) {
        OutputView.printResult(names, lines);
    }
}
