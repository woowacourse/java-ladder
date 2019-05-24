package ladder;

import ladder.model.*;
import ladder.model.generator.MemberGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class AppController {

    public void play(){
        LadderGame ladderGame = initGame();
        EndResult results = playGame(ladderGame);
        endGame(results, ladderGame.getMembersName());
    }

    private LadderGame initGame() {
        Members members = new Members(MemberGenerator.generateMembers(InputView.inputNames()));
        int countOfMember = members.numberOfMembers();
        Ladder ladder = Ladder.nHeightLadder(countOfMember, InputView.inputLadderHeight());
        // todo: ResultGenerator 구현
        DefaultResults results = new DefaultResults(InputView.inputResults(countOfMember));

        return new LadderGame(members, ladder, results);
    }

    private EndResult playGame(LadderGame ladderGame){
        OutputView.printLadder(ladderGame);
        return ladderGame.executeGame();
    }

    private void endGame(EndResult results, List<String> memberNames) {
        String name = InputView.inputGetMemberResult();
        if (name.equals("all")) {
            OutputView.allPrintResult(results.getAll(), memberNames);
            return;
        }
        OutputView.printMemberResult(results.get(name));
    }
}
