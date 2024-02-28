import domain.generator.RandomGenerator;
import view.InputView;
import view.OutputView;

public class Main {

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(new InputView(), new OutputView(),
                new RandomGenerator());

        ladderGame.run();
    }
}
