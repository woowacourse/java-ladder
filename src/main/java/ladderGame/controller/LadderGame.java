package ladderGame.controller;


import ladderGame.model.ladder.LadderResult;
import ladderGame.model.ladder.LadderResultFactory;
import ladderGame.model.input.Players;
import ladderGame.model.input.PlayersFactory;
import ladderGame.model.input.Results;
import ladderGame.model.input.ResultsFactory;
import ladderGame.model.ladder.Ladder;
import ladderGame.model.ladder.LadderFactory;
import ladderGame.view.InputView;
import ladderGame.view.OutputView;

public class LadderGame {
    private static final String ALL_RESULT = "all";
    private static final String QUIT = "quit";

    public static void main(String[] args) {
        Players players = PlayersFactory.getPlayers(InputView.readPlayerNames());
        Results results = ResultsFactory.getResults(InputView.readResults(), players.size());
        int rows = InputView.readRowNumber();
        int columns = players.size() - 1;
        Ladder ladder = LadderFactory.generateLadder(rows,columns);

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

