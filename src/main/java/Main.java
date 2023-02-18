import controller.LadderController;
import domain.ladder.LadderFactory;
import domain.ladder.RandomScaffoldGenerator;
import domain.ladder.ScaffoldGenerator;

public class Main {

    public static void main(String[] args) {
        ScaffoldGenerator scaffoldGenerator = new RandomScaffoldGenerator();
        LadderFactory ladderFactory = new LadderFactory(scaffoldGenerator);
        LadderController ladderController = new LadderController(ladderFactory);
        ladderController.run();
    }
}
