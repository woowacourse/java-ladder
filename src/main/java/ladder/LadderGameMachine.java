package ladder;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.Destination;
import ladder.domain.Destinations;
import ladder.domain.GameResult;
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
        UserNames userNames = initNames();
        LadderHeight ladderHeight = initLadderHeight();
        Lines lines = Lines.of(new RandomBooleanGenerator(), ladderHeight.value(), userNames.getUserCount());
        Destinations destinations = initDestinations(userNames.getUserCount());
        Ladder ladder = createLadder(userNames, lines, destinations);
        OutputView.printLadder(ladder);
        GameResults gameResults = new GameResults(userNames, lines.findStepPositions(), destinations.getDestinations());
        printGameResult(gameResults, userNames);
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
        List<String> destinationValues = destinations.getDestinations().stream()
                .map(Destination::value)
                .toList();
        return new Ladder(userNames.getUserNames(), lineResults, destinationValues);
    }

    private void printGameResult(GameResults gameResults, UserNames userNames) {
        RequestName requestName = initRequestName(userNames);
        while (requestName.isNotAll()) {
            String result = gameResults.findByUserName(requestName.getRequestName());
            OutputView.printOneResult(result);
            requestName = initRequestName(userNames);
        }
        List<AllResults> results = generateAllResults(gameResults.findAll());
        OutputView.printAllResults(results);
    }

    private RequestName initRequestName(UserNames userNames) {
        try {
            String input = InputView.readRequestName(CONSOLE);
            return new RequestName(input, userNames);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return initRequestName(userNames);
        }
    }

    private List<AllResults> generateAllResults(final List<GameResult> gameResults) {
        List<GameResult> results = new ArrayList<>(gameResults);
        return results.stream()
                .map(result -> new AllResults(result.getUserName().value(), result.getDestination().value()))
                .toList();
    }
}
