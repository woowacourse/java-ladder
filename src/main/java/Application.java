import domain.*;
import ui.input.InputView;
import ui.output.OutputView;

import java.util.List;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class Application {
    public static void main(String[] args) {
//        Lines lines = new LadderGame().createLines(10, 5);
//        for (Line line : lines.getLines()) {
//            for (boolean tf : line.getPoints()) {
//                System.out.print(tf + " ");
//            }
//            System.out.println();
//        }

        List<String> names = InputView.getPeoplesName();
        LadderGame ladderGame = new LadderGame();
        Peoples peoples = ladderGame.createPeoples(names);
        int ladderHeight = InputView.getLadderHeight();
        Lines lines = ladderGame.createLines(peoples.getPeoples().size(), ladderHeight);
        OutputView.printResult(peoples, lines);
    }
}
