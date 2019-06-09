package ladderGame.controller;

import ladderGame.model.input.*;
import ladderGame.model.ladder.Ladder;
import ladderGame.model.ladder.LadderFactory;
import ladderGame.model.ladder.LadderResult;
import ladderGame.model.ladder.LadderResultFactory;
import ladderGame.view.InputView;
import ladderGame.view.OutputView;

public class LadderGame {
    private static final String ALL_RESULT = "all";
    private static final String QUIT = "quit";

    public static void main(String[] args) {
        Players players = PlayersFactory.getPlayers(InputView.readPlayerNames());
        Results results = ResultsFactory.getResults(InputView.readResults(), players.size());
        int rowNumber = RowNumberValidator.validates(InputView.readRowNumber());
        int columnNumber = players.size();
        Ladder ladder = LadderFactory.generateLadder(rowNumber, columnNumber);
        OutputView.printLadder(ladder, players.getNames(), results.getNames());
        showResultUntilUserQuits(LadderResultFactory
                .generatesResult(ladder, players.getNames(), results.getNames()));
    }

    private static String showResultUntilUserQuits(LadderResult ladderResult) {
        String player = InputView.readPlayer();
        if (player.equals(ALL_RESULT)) {
            OutputView.printAllResults(ladderResult.getAllResult());
        }
        if (player.equals(QUIT)) {
            return QUIT;
        }
        if (ladderResult.getPlayers().contains(player)) {
            OutputView.printOnePlayerResult(ladderResult.getAllResult(), player);
        }
        return showResultUntilUserQuits(ladderResult);
    }
}

