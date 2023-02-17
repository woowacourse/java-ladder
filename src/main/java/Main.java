import controller.LadderController;
import domain.LadderFactory;
import domain.RandomScaffoldGenerator;
import domain.ScaffoldGenerator;

public class Main {

    public static void main(String[] args) {
        ScaffoldGenerator scaffoldGenerator = new RandomScaffoldGenerator();
        LadderFactory ladderFactory = new LadderFactory(scaffoldGenerator);
        LadderController ladderController = new LadderController(ladderFactory);
        ladderController.run();
    }
}
