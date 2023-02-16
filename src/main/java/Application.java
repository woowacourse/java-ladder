import controller.Controller;
import domain.Ladder;
import domain.Users;
import utils.LadderRowGenerator;
import utils.RandomLadderRowGenerator;

public class Application {
    public static void main(String[] args) {
        Ladder ladder = new Ladder();
        Users users = new Users();
        LadderRowGenerator ladderRowGenerator = new RandomLadderRowGenerator();

        Controller controller = new Controller(ladder, users, ladderRowGenerator);
        controller.run();
    }
}
