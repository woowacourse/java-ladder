import controller.Controller;
import domain.Ladder;
import domain.Users;

public class Application {
    public static void main(String[] args) {
        Ladder ladder = new Ladder();
        Users users = new Users();

        Controller controller = new Controller(ladder, users);
        controller.run();
    }
}
