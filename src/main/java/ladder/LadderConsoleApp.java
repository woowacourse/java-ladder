package ladder;

import ladder.domain.Ladder;
import ladder.view.OutputConsoleView;

public class LadderConsoleApp {
    public static void main(String[] args) {
        Ladder ladder = new Ladder(8, 5);
        OutputConsoleView.printLadder(ladder);
    }
}
