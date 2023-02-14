import controller.Controller;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller( new InputView(new Scanner(System.in)),new OutputView());
        controller.run();
    }
}
