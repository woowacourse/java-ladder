package ladder.controller;

import ladder.domain.ResultPairs;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameResult {
    private final ResultPairs pairs;
    private static final String ALL = "all";

    public LadderGameResult(ResultPairs pairs) {
        this.pairs = pairs;
    }

    public void requestResult() {
        String name;
        while (!(name = InputView.getName()).equals(ALL)) {
            checkName(name);
        }
        OutputView.printResultAll(pairs);
    }

    private void checkName(String name) {
        if (pairs.hasName(name)) {
            OutputView.printResult(pairs.findPlayer(name));
            return;
        }
        OutputView.printResultErrorMsg();
    }
}