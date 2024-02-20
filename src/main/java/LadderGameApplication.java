import controller.LadderGame;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class LadderGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();
        LadderGame ladderGame = new LadderGame(inputView, outputView);

        ladderGame.start();
    }
}
