package ladder;

import ladder.domain.LadderGame;
import ladder.domain.LadderGameFactory;
import ladder.dto.ResultDto;
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
        final LadderGameFactory gameFactory = initFactory();

        final LadderGame game = repeatUntilValid(() -> initGame(gameFactory));
        OutputView.printLadder(game.getPlayerNames(), game.getLadder(), game.getResults());
        playUntilQueryAll(game);
    }

    private static LadderGameFactory initFactory() {
        final LineStrategy lineStrategy = new RandomDiscreteStrategy();
        return new LadderGameFactory(lineStrategy);
    }

    private static LadderGame initGame(LadderGameFactory factory) {
        List<String> names = InputView.readNames();
        List<String> results = InputView.readResults();
        int height = InputView.readLadderHeight();
        return factory.generateGame(names, results, height);
    }

    private static void playUntilQueryAll(LadderGame game) {
        String queryName = "";
        while (!queryName.equals(QUERY_ALL)) {
            queryName = InputView.readInquireName();
            playOneTime(game, queryName);
        }
    }

    private static void playOneTime(final LadderGame game, final String queryName) {
        List<ResultDto> results = game.play(queryName, QUERY_ALL);
        OutputView.printInquireResult(new ResultDtos(results));
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
