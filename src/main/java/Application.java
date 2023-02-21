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
        List<String> names = InputView.inputPersonName();
        LadderGame ladderGame = new LadderGame();
        Person person = ladderGame.createPerson(names);
        int ladderHeight = InputView.inputLadderHeight();

        Lines lines = ladderGame.createLines(person.getPerson().size(), ladderHeight);
        OutputView.printResult(person, lines);
    }
}
