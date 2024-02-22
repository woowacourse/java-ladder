import controller.LadderController;
import domain.Ladder;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class LadderGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();
        LadderController ladderController = new LadderController(inputView, outputView);

        Ladder ladder = ladderController.createLadder();
    }
}
