import controller.Controller;
import utils.LadderRowGenerator;
import utils.RandomLadderRowGenerator;

public class Application {

    public static void main(String[] args) {
        LadderRowGenerator ladderRowGenerator = new RandomLadderRowGenerator();

        Controller controller = new Controller(ladderRowGenerator);
        controller.run();
    }
}
