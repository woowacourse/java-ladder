package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.LadderGameResult;
import ladder.domain.Player;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LadderController {

    private static final String SPLIT_SEPARATOR = ",";

    public static void main(String[] args) {
        String[] names = inputComponent(InputView.inputNames());
        String[] prizes = inputComponent(InputView.inputPrize());
        int height = InputView.inputHeight();

        List<Player> players = addPlayer(names);
        Ladder ladder = new Ladder(names.length, height);

        LadderGame ladderGame = new LadderGame(ladder, players, prizes);
        OutputView.printLadderGame(ladderGame);

        LadderGameResult ladderGameResult = ladderGame.start();
        showGameResult(ladderGameResult);
    }

    private static void showGameResult(LadderGameResult ladderGameResult) {
        String inputNameForResult;
        do {
            inputNameForResult = InputView.inputNameForResult();
            OutputView.printLadderGameResult(ladderGameResult, inputNameForResult);
        } while (!inputNameForResult.equals(OutputView.ALL_USER));
    }

    private static String[] inputComponent(String component) {
        return splitNames(component);
    }

    private static List<Player> addPlayer(String[] names) {
        List<Player> players = new ArrayList<>();
        for (String name : names) {
            players.add(new Player(name));
        }
        return players;
    }

    public static String[] splitNames(String names) {
        return names.split(SPLIT_SEPARATOR);
    }
}
