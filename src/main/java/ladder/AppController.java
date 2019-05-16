package ladder;

import ladder.model.LadderGame;
import ladder.model.Member;
import ladder.model.Members;
import ladder.view.InputView;

import java.util.List;

public class AppController {

    public LadderGame startGame() {
        String[] names = InputView.inputNames();
        List<Member> members = Members.generateMembers(names);
        int ladderHeight = InputView.inputLadderHeight();

        return new LadderGame(members, ladderHeight);
    }
}
