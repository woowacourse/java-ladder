import controller.MainController;
import utils.BooleanGenerator;
import utils.RandomBooleanGenerator;

public class Application {
    public static void main(String[] args) {
        BooleanGenerator booleanGenerator = new RandomBooleanGenerator();
        MainController mainController = new MainController(booleanGenerator);

        mainController.start();
    }
}
