import controller.LadderController;
import util.RandomStoolGenerator;
import view.InputView;
import view.OutputView;

public class Application {
	public static void main(String[] args) {
		LadderController controller = new LadderController(new InputView(), new OutputView(), new RandomStoolGenerator());

		controller.init();
		controller.showLadder();
	}
}
