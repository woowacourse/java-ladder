import controller.LadderController;
import util.RandomStoolGenerator;
import util.StoolGenerator;
import view.InputView;
import view.OutputView;

public class Application {
	public static void main(String[] args) {
		LadderController controller = new LadderController(inputView(), outputView(), stoolGenerator());

		controller.run();
	}

	private static InputView inputView() {
		return new InputView();
	}

	private static OutputView outputView() {
		return new OutputView();
	}

	private static StoolGenerator stoolGenerator() {
		return new RandomStoolGenerator();
	}
}
