package ladder;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class AppController {

    public void play(){
        LadderGame ladderGame = initGame();
        EndResult results = playGame(ladderGame);
        endGame(results);
    }

    private LadderGame initGame() {
        String[] names = InputView.inputNames();
        List<Member> members = Members.generateMembers(names);
        List<String> results = Arrays.asList(InputView.inputResults(members.size()));
        int ladderHeight = InputView.inputLadderHeight();

        return new LadderGame(members, ladderHeight, results);
    }

    private EndResult playGame(LadderGame ladderGame){
        OutputView.printLadder(ladderGame);
        return ladderGame.excuteGame();
    }

    private void endGame(EndResult results) {
        String name = InputView.inputGetMemberResult();
        if (name.equals("all")) {
            OutputView.allPrintResult(results.getAllResult());
            return;
        }
        OutputView.printMemberResult(results.getMemberResult(name));
    }
}
