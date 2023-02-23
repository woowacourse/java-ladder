import controller.LadderGameController;
import domain.util.PointGenerator;
import domain.util.RandomPointGenerator;

public class Application {
	public static void main(String[] args) {
		PointGenerator pointGenerator = new RandomPointGenerator();
		LadderGameController ladderGameController = new LadderGameController(pointGenerator);
		ladderGameController.runGame();
	}
}
