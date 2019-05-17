package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderController {

    private static final String SPLIT_SEPARATOR = ",";

    public static void main(String[] args) {
        String[] unrefinedNames = inputComponent(InputView.inputNames());
        List<Player> players = addPlayer(unrefinedNames);

        String[] unrefinedPrizes = inputComponent(InputView.inputPrize());
        List<Prize> prizes = addPrize(unrefinedPrizes);

        int height = InputView.inputHeight();

        Ladder ladder = new Ladder(unrefinedNames.length, height);

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
        return Arrays.stream(names)
                .map(Player::new)
                .collect(Collectors.toList());
    }

    private static List<Prize> addPrize(String[] prizes) {
        return Arrays.stream(prizes)
                .map(Prize::new)
                .collect(Collectors.toList());
    }

    public static String[] splitNames(String names) {
        return names.split(SPLIT_SEPARATOR);
    }
}
