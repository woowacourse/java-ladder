package ladder;

import ladder.model.LadderGame;
import ladder.model.Member;
import ladder.model.Members;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class AppController {

    public void play(){
        LadderGame ladderGame = initGame();
        playGame(ladderGame);
    }

    private LadderGame initGame() {
        String[] names = InputView.inputNames();
        List<Member> members = Members.generateMembers(names);
        List<String> results = Arrays.asList(InputView.inputResults(members.size()));
        int ladderHeight = InputView.inputLadderHeight();

        return new LadderGame(members, ladderHeight, results);
    }

    private void playGame(LadderGame ladderGame){
        OutputView.printLadder(ladderGame);
    }
}
