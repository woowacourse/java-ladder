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
        LadderGame ladderGame = new LadderGame();
        Person person = inputPerson(ladderGame);
        int ladderHeight = InputView.inputLadderHeight();

        Lines lines = ladderGame.createLines(person.getPerson().size(), ladderHeight);
        OutputView.printResult(person, lines);
    }

    private static Person inputPerson(LadderGame ladderGame){
        while (true){
            try {
                List<String> names = InputView.inputPersonName();
                return ladderGame.createPerson(names);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
