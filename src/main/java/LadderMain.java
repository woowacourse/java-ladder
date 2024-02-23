import game.LadderGame;
import generator.LadderFloorGenerator;
import java.util.Random;

import view.InputView;
import view.OutputView;

public class LadderMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Random random = new Random();
        LadderFloorGenerator floorGenerator = new LadderFloorGenerator(random::nextBoolean);

        LadderGame ladderGame = new LadderGame(inputView, outputView, floorGenerator);
        ladderGame.play();
    }
}
