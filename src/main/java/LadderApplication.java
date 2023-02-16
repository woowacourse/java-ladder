import controller.LadderController;
import java.util.Scanner;
import model.LadderMaker;
import strategy.RandomPassGenerator;
import view.InputView;
import view.OutputView;

public class LadderApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();
        LadderMaker ladderMaker = new LadderMaker(new RandomPassGenerator());
        LadderController ladderController = new LadderController(inputView, outputView, ladderMaker);

        ladderController.run();
    }

}
