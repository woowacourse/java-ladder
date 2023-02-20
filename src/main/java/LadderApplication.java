import controller.LadderController;
import model.LadderMaker;
import utils.LadderApplicationConfig;

public class LadderApplication {

    public static void main(String[] args) {
        LadderApplicationConfig config = new LadderApplicationConfig();
        LadderController controller = config.ladderController();
        LadderMaker ladderMaker = config.ladderMaker();

        controller.run(ladderMaker);
    }

}
