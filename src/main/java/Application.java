import domain.LadderGame;
import domain.Lines;
import domain.People;
import domain.Rewards;
import java.util.List;
import ui.input.InputView;
import ui.output.OutputView;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class Application {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();
        People people = inputPeople(ladderGame);
        Rewards rewards = inputRewards(ladderGame, people.getPeople().size());
        int ladderHeight = InputView.inputLadderHeight();

        Lines lines = ladderGame.createLines(people.getPeople().size(), ladderHeight);
        OutputView.printResult(people, lines, people.calculateMaxNameLength());
    }

    private static People inputPeople(LadderGame ladderGame) {
        while (true) {
            try {
                List<String> names = InputView.inputPersonName();
                return ladderGame.createPeople(names);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Rewards inputRewards(LadderGame ladderGame, int peopleNum) {
        while (true) {
            try {
                List<String> names = InputView.inputRewards(peopleNum);
                return ladderGame.createRewards(names, peopleNum);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
