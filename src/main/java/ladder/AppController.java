package ladder;

import ladder.model.*;

import java.util.List;

import static ladder.model.generator.LadderGenerator.generateLadder;
import static ladder.model.generator.MemberGenerator.generateMembers;
import static ladder.model.generator.ResultsGenerator.generateResults;
import static ladder.view.InputView.*;
import static ladder.view.OutputView.*;

public class AppController {

    public void play(){
        LadderGame ladderGame = initGame();
        EndResult results = playGame(ladderGame);
        endGame(results, ladderGame.getMembersName());
    }

    private LadderGame initGame() {
        Members members = new Members(generateMembers(inputNames()));
        int countOfMember = members.numberOfMembers();
        Ladder ladder = generateLadder(countOfMember, inputLadderHeight());
        DefaultResults results = new DefaultResults(generateResults(inputResults(countOfMember)));

        return new LadderGame(members, ladder, results);
    }

    private EndResult playGame(LadderGame ladderGame){
        printLadder(ladderGame);
        return ladderGame.executeGame();
    }

    private void endGame(EndResult results, List<String> memberNames) {
        String name = inputGetMemberResult(memberNames);
        if (name.equals("all")) {
            allPrintResult(results.getAll(), memberNames);
            return;
        }
        printMemberResult(results.get(name));
    }
}
