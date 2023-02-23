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
        People people = inputPeople(ladderGame);
        int ladderHeight = InputView.inputLadderHeight();

        Lines lines = ladderGame.createLines(people.getPeople().size(), ladderHeight);
        OutputView.printResult(people, lines, people.calculateMaxNameLength());
    }

    private static People inputPeople(LadderGame ladderGame){
        while (true){
            try {
                List<String> names = InputView.inputPersonName();
                return ladderGame.createPeople(names);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
