package ladder.controller;

import java.util.List;
import java.util.Map;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderGenerator;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.Prizes;
import ladder.domain.ResultCommand;
import ladder.domain.Width;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {
    private final InputView inputView;
    private final ResultView resultView;

    public LadderGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        try {
            Players players = enroll();
            Prizes prizes = getPrizes(players.size());
            Ladder ladder = makeLadder(players.size());
            printLadder(players, ladder, prizes);

            runGame(players, prizes, ladder);

            printResult(players);
        } catch (IllegalArgumentException e) {
            resultView.printErrorMessage(e.getMessage());
        }

    }

    private void printResult(Players players) {
        ResultCommand resultCommand = ResultCommand.from(inputView.inputPlayerForResult());
        if (resultCommand.equals(ResultCommand.PLAYER)) {
            String prizeName = getPrizeNameByPlayerName(resultCommand.getName(), players);
            resultView.printPrizeOfPlayer(prizeName);
            printResult(players);
        }
        if (resultCommand.equals(ResultCommand.ALL)) {
            resultView.printPrizeOfPlayers(getPrizeResult(players));
            printResult(players);
        }
        if (resultCommand.equals(ResultCommand.END)) {
            resultView.printEndMessage();
        }
    }

    private Map<String, String> getPrizeResult(Players players) {
        return players.getPrizes();
    }

    private String getPrizeNameByPlayerName(String playerName, Players players) {
        return getPrizeNameOfPlayer(players.findByName(playerName));
    }

    private String getPrizeNameOfPlayer(Player player) {
        return player.getPrizeName();
    }

    private void runGame(Players players, Prizes prizes, Ladder ladder) {
        List<Integer> orders = ladder.getAllEndPosition();
        Prizes orderedPrizes = prizes.getOrderedPrizes(orders);
        players.setPrizes(orderedPrizes);
    }

    private Players enroll() {
        List<String> names = inputView.inputPlayers();
        return Players.from(names);
    }

    private Prizes getPrizes(int expectedSize) {
        List<String> names = inputView.inputPrizes();
        return Prizes.from(names, expectedSize);
    }

    private Ladder makeLadder(int playersSize) {
        Height height = new Height(inputView.inputHeight());
        Width width = new Width(getWidthSize(playersSize));
        LadderGenerator ladderGenerator = new LadderGenerator(width, height);
        return ladderGenerator.generateLadder();
    }

    private int getWidthSize(int playersSize) {
        return playersSize - 1;
    }

    private void printLadder(Players players, Ladder ladder, Prizes prizes) {
        resultView.printLadderResultHeader();
        resultView.printNames(players.getNames());
        resultView.printLadder(ladder.getLadder());
        resultView.printNames(prizes.getNames());
    }
}
