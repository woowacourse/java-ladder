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
        List<String> names = InputView.getPersonName();
        LadderGame ladderGame = new LadderGame();
        Person person = ladderGame.createPeoples(names);
        int ladderHeight = InputView.getLadderHeight();

        Lines lines = ladderGame.createLines(person.getPerson().size(), ladderHeight);
        OutputView.printResult(person, lines);
    }
}
