import controller.LadderGameController;
import domain.ladder.stick.RandomStickGenerator;
import domain.ladder.stick.StickGenerator;
import domain.ladder.sticks.NotRepeatedSticksGenerator;
import domain.ladder.sticks.SticksGenerator;
import view.InputView;
import view.OutputView;

class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        StickGenerator stickGenerator = new RandomStickGenerator();
        SticksGenerator sticksGenerator = new NotRepeatedSticksGenerator(stickGenerator);

        LadderGameController ladderGameController = new LadderGameController(inputView, outputView, sticksGenerator);

        ladderGameController.run();
    }
}
