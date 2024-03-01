package ladder;

import ladder.controller.Controller;
import ladder.view.InputView;
import ladder.view.ResultView;
import ladder.view.exception.ExceptionHandler;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(
                new InputView(new ExceptionHandler()),
                new ResultView()
        );
        controller.run();
    }
}
