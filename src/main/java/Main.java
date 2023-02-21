import controller.LadderController;
import domain.game.LadderGameFactory;
import domain.ladder.LadderFactory;
import domain.ladder.RandomScaffoldGenerator;
import domain.ladder.ScaffoldGenerator;

public class Main {

    public static void main(String[] args) {
        ScaffoldGenerator scaffoldGenerator = new RandomScaffoldGenerator();
        LadderFactory ladderFactory = new LadderFactory(scaffoldGenerator);
        LadderGameFactory ladderGameFactory = new LadderGameFactory(ladderFactory);
        LadderController ladderController = new LadderController(ladderGameFactory);
        ladderController.run();
    }
}
