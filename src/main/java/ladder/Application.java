package ladder;

import ladder.domain.Command;
import ladder.domain.LadderGame;
import ladder.dto.ResultDto;
import ladder.utils.RandomDiscreteStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        final var lineStrategy = new RandomDiscreteStrategy();
        Command command = readCommand();

        LadderGame game = new LadderGame(command, lineStrategy);
        OutputView.printLadder(game.getPlayerNames(), game.getLadder(), game.getResults());

        String queryName = "";
        while (!queryName.equals(LadderGame.QUERY_ALL)) {
            queryName = InputView.readResultInquireName();
            List<ResultDto> results = game.calculatePlayerResult(queryName);
            OutputView.printInquireResult(results);
        }
    }

    private static Command readCommand() {
        List<String> names = InputView.readNames();
        List<String> results = InputView.readResults();
        int height = InputView.readLadderHeight();
        return new Command(names, results, height);
    }
}
