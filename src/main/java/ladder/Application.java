package ladder;

import ladder.domain.LadderGame;
import ladder.domain.LadderGameFactory;
import ladder.dto.ResultDtos;
import ladder.utils.LineStrategy;
import ladder.utils.RandomDiscreteStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

import static ladder.view.InputView.QUERY_ALL;

public class Application {

    public static void main(String[] args) {
        final LineStrategy lineStrategy = new RandomDiscreteStrategy();
        final LadderGameFactory gameFactory = new LadderGameFactory(lineStrategy);

        final LadderGame game = repeatUntilValid(() -> initGame(gameFactory));
        OutputView.printLadder(game.getPlayerNames(), game.getLadder(), game.getResults());
        inquireGameResult(game);
    }

    private static void inquireGameResult(LadderGame game) {
        String queryName = "";
        while (!queryName.equals(QUERY_ALL)) {
            queryName = inquireResult(game);
        }
    }

    private static LadderGame initGame(LadderGameFactory factory) {
        List<String> names = InputView.readNames();
        List<String> results = InputView.readResults();
        int height = InputView.readLadderHeight();
        return factory.generateGame(names, results, height);
    }

    private static String inquireResult(final LadderGame game) {
        String queryName = InputView.readResultInquireName();
        ResultDtos results = new ResultDtos(game.calculatePlayerResult(queryName, QUERY_ALL));
        OutputView.printInquireResult(results);
        return queryName;
    }

    private static <T>T repeatUntilValid(Supplier<T> reader) {
        try {
            return reader.get();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return repeatUntilValid(reader);
        }
    }
}
