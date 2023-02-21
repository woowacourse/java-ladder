import domain.Ladder;
import domain.Prizes;
import domain.RandomLinkGenerator;
import domain.Users;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        final Users users = generateUsers();
        final Ladder ladder = generateLadder(users);
        final Prizes prizes = generatePrizes(users);
        printResult(ladder, users);
    }

    private static Prizes generatePrizes(final Users users) {
        try {
            return new Prizes(InputView.readPrizeNames(), users);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return generatePrizes(users);
        }
    }

    private static Users generateUsers() {
        try {
            return new Users(InputView.readUserNames());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return generateUsers();
        }
    }

    private static Ladder generateLadder(Users users) {
        try {
            return new Ladder(InputView.readLadderHeight(), users.size(), new RandomLinkGenerator());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return generateLadder(users);
        }
    }

    private static void printResult(final Ladder ladder, final Users users) {
        OutputView.printResultMessage();
        OutputView.printUserNames(users.getUsersName());
        OutputView.printResult(ladder.getLines());
    }
}
