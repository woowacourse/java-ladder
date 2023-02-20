import controller.LadderController;
import java.util.Scanner;
import model.LadderMaker;
import strategy.RandomPassGenerator;
import view.InputView;
import view.OutputView;

public class LadderApplication {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            LadderController controller = new LadderController(new InputView(scanner), new OutputView());

            controller.run(new LadderMaker(new RandomPassGenerator()));
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
