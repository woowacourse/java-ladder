package controller;

import java.util.List;
import java.util.function.Supplier;
import model.gameResult.GameResult;
import model.ladder.Ladder;
import model.ladder.LadderHeight;
import model.line.RandomLineGenerator;
import model.player.Players;
import model.prize.Prize;
import model.prize.Prizes;
import view.InputView;
import view.OutputView;

public class LadderGameController {
    public void run() {
        Players players = preparePlayers();
        Prizes prizes = preparePrizes(players);
        LadderHeight ladderHeight = prepareLadderHeight();

        RandomLineGenerator randomLineGenerator = new RandomLineGenerator();
        Ladder ladder = Ladder.of(ladderHeight, players, randomLineGenerator);
        GameResult gameResult = ladder.simulate(players, prizes);

        end(players, ladder, prizes);

        boolean isContinue = true;
        while(isContinue) {
            isContinue = searchPrize(gameResult);
        }
    }

    private boolean searchPrize(GameResult gameResult) {
        return retryOnException(() -> {
            String playerName = InputView.askPlayerNameForPrizeSearch();
            if (playerName.equals("all")) {
                OutputView.printGameResultAll(gameResult);
                return false;
            }
            Prize prize = gameResult.findPrizeByPlayerName(playerName);
            OutputView.printGameResult(prize);
            return true;
        });
    }

    private Players preparePlayers() {
        return retryOnException(() -> {
            List<String> playerNames = InputView.askPlayerNames();
            return Players.of(playerNames);
        });
    }

    private Prizes preparePrizes(Players players) {
        return retryOnException(() -> {
            List<String> prizeNames = InputView.askPrizeNames();
            return Prizes.from(prizeNames, players);
        });
    }

    private LadderHeight prepareLadderHeight() {
        return retryOnException(() -> {
            int ladderHeight = InputView.askLadderHeight();
            return new LadderHeight(ladderHeight);
        });
    }

    private void end(Players players, Ladder ladder, Prizes prizes) {
        OutputView.printLadderResultIntro();
        OutputView.printPlayerNames(players);
        OutputView.printLadder(ladder);
        OutputView.printPrizeNames(prizes);
    }

    private <T> T retryOnException(Supplier<T> retryOperation) {
        try {
            return retryOperation.get();
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return retryOnException(retryOperation);
        }
    }
}
