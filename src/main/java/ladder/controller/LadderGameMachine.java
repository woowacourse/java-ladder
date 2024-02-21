package ladder.controller;

import ladder.domain.LadderHeight;
import ladder.domain.UserNames;
import ladder.util.ConsoleReader;
import ladder.view.InputView;

import java.util.List;

public class LadderGameMachine {
    private static final ConsoleReader CONSOLE = new ConsoleReader();

    public void run() {
        initNames();
        initLadderHeight();
    }

    private UserNames initNames() {
        try {
            List<String> input = InputView.readNames(CONSOLE);
            return UserNames.of(input);
        } catch (IllegalArgumentException e) {
            // TODO: 예외 메시지 출력
            return initNames();
        }
    }

    private LadderHeight initLadderHeight() {
        try {
            int input = InputView.readLadderHeight(CONSOLE);
            return new LadderHeight(input);
        } catch (IllegalArgumentException e) {
            // TODO: 예외 메시지 출력
            return initLadderHeight();
        }
    }
}
