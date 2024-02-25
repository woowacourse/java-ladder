package ladder;

import java.util.List;
import ladder.domain.Destinations;
import ladder.domain.LadderHeight;
import ladder.domain.Lines;
import ladder.domain.UserNames;
import ladder.dto.Ladder;
import ladder.dto.LineResult;
import ladder.util.ConsoleReader;
import ladder.util.RandomBooleanGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameMachine {
    private static final ConsoleReader CONSOLE = new ConsoleReader();

    public void run() {
        UserNames userNames = initNames();
        LadderHeight ladderHeight = initLadderHeight();
        Lines lines = Lines.of(new RandomBooleanGenerator(), ladderHeight.value(), userNames.getUserCount());
        Destinations destinations = initDestinations(userNames.getUserCount());
        Ladder ladder = createLadder(userNames, lines, destinations);
        OutputView.printLadder(ladder);
    }

    private UserNames initNames() {
        try {
            List<String> input = InputView.readNames(CONSOLE);
            return UserNames.from(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return initNames();
        }
    }

    private LadderHeight initLadderHeight() {
        try {
            int input = InputView.readLadderHeight(CONSOLE);
            return new LadderHeight(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return initLadderHeight();
        }
    }

    private Destinations initDestinations(final int userCount) {
        try {
            List<String> input = InputView.readDestinations(CONSOLE);
            return Destinations.of(input, userCount);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return initDestinations(userCount);
        }
    }

    private Ladder createLadder(UserNames userNames, Lines lines, Destinations destinations) {
        List<LineResult> lineResults = lines.getLines().stream()
                .map(line -> new LineResult(line.getLine()))
                .toList();
        return new Ladder(userNames.getUserNames(), lineResults, destinations.getDestinations());
    }
}
