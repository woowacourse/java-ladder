import controller.LadderController;
import java.util.Scanner;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LadderController controller = new LadderController(
                new InputView(scanner),
                new OutputView()
        );
        controller.run();
    }
}
