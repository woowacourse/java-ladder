package ladder;

import ladder.domain.Command;
import ladder.domain.LadderGame;
import ladder.dto.ResultDto;
import ladder.utils.LineStrategy;
import ladder.utils.RandomDiscreteStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

import static ladder.view.InputView.QUERY_ALL;

public class Application {

    public static void main(String[] args) {
        final var lineStrategy = new RandomDiscreteStrategy();

        final LadderGame game = repeat(() -> initGame(lineStrategy));
        OutputView.printLadder(game.getPlayerNames(), game.getLadder(), game.getResults());
        inquireGameResult(game);
    }

    private static void inquireGameResult(LadderGame game) {
        String queryName = "";
        while (!queryName.equals(QUERY_ALL)) {
            queryName = inquireResult(game);
        }
    }

    private static LadderGame initGame(LineStrategy lineStrategy) {
        Command command = readCommand();
        return new LadderGame(command, lineStrategy);
    }

    private static String inquireResult(final LadderGame game) {
        String queryName = InputView.readResultInquireName();
        List<ResultDto> results = game.calculatePlayerResult(queryName, QUERY_ALL);
        OutputView.printInquireResult(results);
        return queryName;
    }

    private static Command readCommand() {
        List<String> names = InputView.readNames();
        List<String> results = InputView.readResults();
        int height = InputView.readLadderHeight();
        return new Command(names, results, height);
    }

    private static <T>T repeat(Supplier<T> reader) {
        try {
            return reader.get();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return repeat(reader);
        }
    }
}
