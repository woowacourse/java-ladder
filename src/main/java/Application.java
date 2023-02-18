import domain.*;
import ui.input.InputView;
import ui.output.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> names = InputView.getPeoplesName();
        LadderGame ladderGame = new LadderGame();
        Peoples peoples = ladderGame.createPeoples(names);
        int ladderHeight = InputView.getLadderHeight();

        Lines lines = ladderGame.createLines(peoples.getPeoples().size(), ladderHeight);
        OutputView.printResult(peoples, lines);
    }
}
