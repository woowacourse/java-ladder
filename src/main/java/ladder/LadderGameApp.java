package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.view.OutputView;

import java.util.List;

public class LadderGameApp {
    public static void main(String[] args) {
        List<String> names = LadderGame.getPersonNames();
        int height = LadderGame.getLadderHeight();
        OutputView.printLadder(new Ladder(names.size(), height));
    }
}
