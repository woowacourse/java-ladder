import controller.LadderGameController;
import view.InputView;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        LadderGameController controller = new LadderGameController(
                new InputView(),
                new OutputView()
        );

        execute(controller);
    }

    private static void execute(LadderGameController controller) {
        try {
            controller.run();
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
        }
    }
}
