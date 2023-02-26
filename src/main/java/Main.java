import controller.LadderGameController;
import domain.InputValidator;
import view.InputView;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        LadderGameController controller = new LadderGameController(
                new InputView(new InputValidator()),
                new OutputView()
        );

        execute(controller);
    }

    private static void execute(LadderGameController controller) {
        try {
            controller.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
