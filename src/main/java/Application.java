import controller.LadderController;
import view.InputView;
import view.OutputView;

public class Application {
	public static void main(String[] args) {
		LadderController controller = new LadderController(new InputView(), new OutputView());

		controller.init();
	}
}
