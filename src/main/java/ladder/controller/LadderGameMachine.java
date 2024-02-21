package ladder.controller;

import ladder.domain.UserNames;
import ladder.util.ConsoleReader;
import ladder.view.InputView;

import java.util.List;

public class LadderGameMachine {

    public void run() {
        initNames();
    }

    private UserNames initNames() {
        try {
            List<String> input = InputView.readNames(new ConsoleReader());
            return UserNames.of(input);
        } catch (IllegalArgumentException e) {
            // TODO: 예외 메시지 출력
            return initNames();
        }
    }
}
