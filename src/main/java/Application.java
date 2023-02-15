import controller.RadderGameController;
import domain.Ladder;
import domain.Participants;
import util.RandomBooleanGenerator;
import view.input.InputView;
import view.output.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomBooleanGenerator randomBooleanGenerator = new RandomBooleanGenerator();
        RadderGameController radderGameController = new RadderGameController();
        Participants participants = radderGameController.makeParticipants(inputView);
        Ladder ladder = radderGameController.makeLadder(inputView, participants, randomBooleanGenerator);
        radderGameController.showLadder(outputView, participants, ladder);
    }
}
