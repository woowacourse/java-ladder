package ladderGame;

import ladderGame.view.InputView;
import ladderGame.view.OutputView;

public class LadderGame {

    public static void main(String[] args) {
        String[] names = InputView.readNames();
        int rows = InputView.readRows();

        LadderFactory ladderFactory = new LadderFactory(new LadderRowFactory());
        Ladder ladder = ladderFactory.newInstance(rows, names.length - 1 );

        System.out.println("실행결과");
        LadderDrawer ladderDrawer = new LadderDrawer();
        ladderDrawer.draw(ladder, rows);

        OutputView.printNames(names);
        OutputView.printLadder(ladder.drawn());

    }
}
