import controller.LadderController;
import domain.ladder.Ladder;
import domain.ladder.LadderHeight;
import domain.ladder.LadderResults;
import domain.player.PlayerNames;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class LadderGameApplication {

    public static void main(String[] args) {
        LadderController ladderController = new LadderController(new InputView(new Scanner(System.in)), new OutputView());

        PlayerNames playerNames = ladderController.readPlayerNames();
        LadderResults results = ladderController.readLadderResults(playerNames.getCount());
        LadderHeight ladderHeight = ladderController.readLadderHeight();

        Ladder ladder = ladderController.createLadder(ladderHeight, playerNames, results);
        ladderController.matchPlayerToResult(ladder, playerNames, results);
    }
}
