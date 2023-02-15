import controller.LadderController;
import service.LadderService;
import util.RandomLineStrategy;
import view.LadderView;

public class Application {
    public static void main(String[] args) {
        LadderService ladderService = new LadderService(new RandomLineStrategy());
        LadderView ladderView = new LadderView();
        LadderController ladderController = new LadderController(ladderService, ladderView);
        ladderController.run();
    }
}
