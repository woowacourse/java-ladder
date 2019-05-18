package ladder;

import ladder.domain.LadderGameBoard;
import ladder.domain.Player;
import ladder.view.OutputView;

import java.util.List;

public class LadderGameApp {
    public static void main(String[] args) {
        LadderGameBoard board = LadderGame.generateGameBoard();
        OutputView.printLadderGameBoard(board);

        LadderGame.executeLadderGame();

        String inputName;
        List<Player> foundPlayers;

        do {
            inputName = LadderGame.getNameForLookup();
            foundPlayers = LadderGame.lookUpResult(inputName);
            OutputView.printResult(foundPlayers);
        } while (!inputName.equals("종료"));

        OutputView.printEnd();
    }
}
