import controller.BlockController;
import java.util.Scanner;
import service.BlockService;
import strategy.RandomPassGenerator;
import view.InputView;
import view.OutputView;

public class Main {

    public static void main(String[] args) {
        BlockController blockController = new BlockController(new InputView(new Scanner(System.in)), new OutputView(),
            new BlockService(new RandomPassGenerator()));
        blockController.run();
    }

}
