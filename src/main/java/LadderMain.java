import controller.LadderGameController;
import view.InputView;
import view.OutputView;

public class LadderMain {

	public static void main(String[] args) {
		LadderGameController controller = new LadderGameController(new InputView(), new OutputView());
		controller.run();
	}
}
