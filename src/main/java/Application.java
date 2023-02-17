import domain.Ladder;
import domain.Users;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        final Users users = generateUsers();
        final Ladder ladder = generateLadder(users);
        printResult(ladder, users);
    }

    private static Ladder generateLadder(Users users) {
        try {
            return Ladder.generateByHeightPersonCount(InputView.readLadderHeight(), users.size());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateLadder(users);
        }
    }

    private static Users generateUsers() {
        try {
            return new Users(InputView.readUserNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateUsers();
        }
    }

    private static void printResult(final Ladder ladder, final Users users) {
        OutputView.printResultMessage();
        OutputView.printUserNames(users.getUsersName());
        OutputView.printResult(ladder.getLines());
    }
}
