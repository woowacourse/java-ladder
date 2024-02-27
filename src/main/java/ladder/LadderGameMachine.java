package ladder;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.Destinations;
import ladder.domain.UserDestination;
import ladder.domain.GameResults;
import ladder.domain.LadderHeight;
import ladder.domain.Lines;
import ladder.domain.RequestName;
import ladder.domain.UserNames;
import ladder.dto.AllResults;
import ladder.dto.Ladder;
import ladder.dto.LineResult;
import ladder.util.ConsoleReader;
import ladder.util.RandomBooleanGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameMachine {
    private static final ConsoleReader CONSOLE = new ConsoleReader();

    public void run() {
        UserNames userNames = registerUserNames();
        LadderHeight ladderHeight = registerLadderHeight();
        Lines lines = Lines.of(new RandomBooleanGenerator(), ladderHeight.value(), userNames.getUserCount());
        Destinations destinations = registerDestinations(userNames.getUserCount());
        Ladder ladder = createLadder(userNames, lines, destinations);
        OutputView.printLadder(ladder);
        GameResults gameResults = new GameResults(userNames, lines.findStepPositions(), destinations);
        printGameResult(gameResults, userNames);
    }

    private UserNames registerUserNames() {
        try {
            List<String> input = InputView.readNames(CONSOLE);
            return UserNames.from(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return registerUserNames();
        }
    }

    private LadderHeight registerLadderHeight() {
        try {
            int input = InputView.readLadderHeight(CONSOLE);
            return new LadderHeight(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return registerLadderHeight();
        }
    }

    private Destinations registerDestinations(final int userCount) {
        try {
            List<String> input = InputView.readDestinations(CONSOLE);
            return Destinations.of(input, userCount);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return registerDestinations(userCount);
        }
    }

    private Ladder createLadder(UserNames userNames, Lines lines, Destinations destinations) {
        List<LineResult> lineResults = lines.getLines().stream()
                .map(line -> new LineResult(line.getLine()))
                .toList();
        return new Ladder(userNames.getUserNames(), lineResults, destinations.getDestinations());
    }

    private void printGameResult(GameResults gameResults, UserNames userNames) {
        RequestName requestName = registerRequestNames(userNames);
        while (requestName.isNotAll()) {
            String result = gameResults.findByUserName(requestName.getRequestName());
            OutputView.printOneResult(result);
            requestName = registerRequestNames(userNames);
        }
        List<AllResults> results = generateAllResults(gameResults.findAll());
        OutputView.printAllResults(results);
    }

    private RequestName registerRequestNames(UserNames userNames) {
        try {
            String input = InputView.readRequestName(CONSOLE);
            return new RequestName(input, userNames);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return registerRequestNames(userNames);
        }
    }

    private List<AllResults> generateAllResults(final List<UserDestination> userDestinations) {
        List<UserDestination> results = new ArrayList<>(userDestinations);
        return results.stream()
                .map(result -> new AllResults(result.getUserName().value(), result.getDestination().value()))
                .toList();
    }
}
