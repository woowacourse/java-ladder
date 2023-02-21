import controller.Controller;
import domain.Ladder;
import domain.Rewards;
import domain.Users;
import utils.LadderRowGenerator;
import utils.RandomLadderRowGenerator;

public class Application {
    public static void main(String[] args) {
        LadderRowGenerator ladderRowGenerator = new RandomLadderRowGenerator();

        Ladder ladder = new Ladder(ladderRowGenerator);
        Users users = new Users();
        Rewards rewards = new Rewards();

        Controller controller = new Controller(ladder, users, rewards);
        controller.run();
    }
}
