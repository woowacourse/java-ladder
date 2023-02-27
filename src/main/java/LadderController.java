import domain.Height;
import domain.PersonCount;
import domain.ladder.Ladder;
import domain.ladder.RandomLinkGenerator;
import domain.prize.Prizes;
import domain.user.Users;
import java.util.List;
import java.util.stream.Collectors;
import view.InputView;
import view.LineRender;
import view.OutputView;

public class LadderController {

    private static final int MAX_TRY_COUNT = 5;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        int tryCount = 0;
        final Users users = generateUsers();
        final Ladder ladder = generateLadder(users);
        final Prizes prizes = generatePrizes(users);
        printGenerateLadderResult(ladder, users, prizes);
        ladder.playLadderGame(users);
        while (tryCount++ < MAX_TRY_COUNT) {
            readUserAndPrintPrize(users, prizes);
        }
    }

    private void readUserAndPrintPrize(final Users users, final Prizes prizes) {
        try {
            final String userName = inputView.readUserName();
            outputView.printResult(users.getPrizeAndUserName(userName, prizes));
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
            return new Ladder(new Height(inputView.readLadderHeight()), new PersonCount(users.size())
                    , new RandomLinkGenerator());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return generateLadder(users);
        }
    }

    private void printGenerateLadderResult(final Ladder ladder, final Users users, final Prizes prizes) {
        outputView.printLadderResultMessage();
        outputView.printUserNames(users.getUserNames());
        final List<String> renderedLadder = ladder.getLines().stream()
                .map(LineRender::render)
                .collect(Collectors.toUnmodifiableList());
        outputView.printLadders(renderedLadder);
        outputView.printPrizes(prizes.getPrizes());
    }
}
