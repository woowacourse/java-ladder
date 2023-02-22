import domain.Ladder;
import domain.Prizes;
import domain.RandomLinkGenerator;
import domain.Users;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        final Users users = generateUsers();
        final Ladder ladder = generateLadder(users);
        final Prizes prizes = generatePrizes(users);
        printGenerateLadderResult(ladder, users, prizes);
        ladder.playLadderGame(users);
        while (true) {
            readUserAndPrintPrize(users, prizes);
        }
    }

    private void readUserAndPrintPrize(final Users users, final Prizes prizes) {
        try {
            final String userName = inputView.readUserName();
            if (!userName.equals("all")) {
                outputView.printPrize(users.getPrizeByUserName(prizes, userName));
                return;
            }
            outputView.printAllUsersAndPrizes(users.getAllUsersAndPrizes(prizes));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
        }
    }

    private Prizes generatePrizes(final Users users) {
        try {
            return new Prizes(inputView.readPrizeNames(), users);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return generatePrizes(users);
        }
    }

    private Users generateUsers() {
        try {
            return new Users(inputView.readUserNames());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return generateUsers();
        }
    }

    private Ladder generateLadder(Users users) {
        try {
            return new Ladder(inputView.readLadderHeight(), users.size(), new RandomLinkGenerator());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return generateLadder(users);
        }
    }

    private void printGenerateLadderResult(final Ladder ladder, final Users users, final Prizes prizes) {
        outputView.printLadderResultMessage();
        outputView.printUserNames(users.getUserNames());
        outputView.printLadders(ladder.getLines());
        outputView.printPrizes(prizes.getPrizes());
    }
}
