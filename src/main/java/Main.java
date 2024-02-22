import view.InputView;
import view.OutputView;

class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Controller controller = new Controller(inputView, outputView);

        controller.run();
    }
}
