import controller.Controller;
import domain.Ladder;
import domain.ResultTable;
import domain.Rewards;
import domain.Users;
import domain.ladderRowGenerator.LadderRowGenerator;
import domain.ladderRowGenerator.RandomLadderRowGenerator;

public class Application {
    public static void main(String[] args) {
        LadderRowGenerator ladderRowGenerator = new RandomLadderRowGenerator();

        Ladder ladder = new Ladder(ladderRowGenerator);
        Users users = new Users();
        Rewards rewards = new Rewards();
        ResultTable resultTable = new ResultTable();

        Controller controller = new Controller(ladder, users, rewards, resultTable);
        controller.run();
    }
}
