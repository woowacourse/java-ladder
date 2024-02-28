package ladder;

import ladder.controller.Controller;
import ladder.exception.ExceptionHandler;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(
                new InputView(new ExceptionHandler()),
                new ResultView()
        );
        controller.run();
    }
}
