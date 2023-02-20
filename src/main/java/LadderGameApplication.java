import controller.LadderGameController;
import util.RandomNumberGenerator;

import java.security.SecureRandom;

public class LadderGameApplication {

    public static void main(String[] args) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(new SecureRandom());
        LadderGameController ladderGameController = new LadderGameController(randomNumberGenerator);

        try {
            ladderGameController.run();
        } catch (Exception exception) {
            ladderGameController.printError(exception);
        }
    }

}
