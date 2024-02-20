import controller.LadderGame;
import view.InputView;

import java.util.Scanner;

public class LadderGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        LadderGame ladderGame = new LadderGame(inputView);

        ladderGame.start();
    }
}
