package ladder;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class AppController {

    public static final String WRONG_INPUT_MESSAGE = "잘못 입력했습니다.";

    public void play(){
        LadderGame ladderGame = initGame();
        EndResult results = playGame(ladderGame);
        endGame(results);
    }

    private LadderGame initGame() {
        List<String> names = InputView.inputNames();
        Members members = new Members(names);
        List<String> results = InputView.inputResults(members.size());
        int ladderHeight = InputView.inputLadderHeight();

        return new LadderGame(members, ladderHeight, results);
    }

    private EndResult playGame(LadderGame ladderGame){
        OutputView.printLadder(ladderGame);
        return ladderGame.excuteGame();
    }

    private void endGame(EndResult results) {
        String name = InputView.inputGetMemberResult();
        if (name.equals("all") || name.equals("ALL")) {
            OutputView.allPrintResult(results.getAllResult());
            return;
        }

        try {
            OutputView.printMemberResult(results.getMemberResult(name));
        } catch (IllegalArgumentException e) {
            System.out.println(WRONG_INPUT_MESSAGE);
            endGame(results);
        }
    }
}
