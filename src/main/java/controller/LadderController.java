package controller;

import java.util.HashSet;
import java.util.Set;
import model.Height;
import model.Ladder;
import model.LadderDto;
import model.LadderGameResult;
import model.Player;
import model.Players;
import model.Prizes;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Players players = new Players(inputView.readPlayersName());
        Prizes prizes = Prizes.of(inputView.readPrizes(), players.size());
        Height height = new Height(inputView.readHeight());
        Ladder ladder = Ladder.of(height, players, prizes);
        LadderDto ladderDto = LadderDto.from(ladder.getLines());

        outputView.printPlayerNamesAndLadder(players.getNames(), ladderDto.formattedLadder());
        outputView.printPrizes(prizes.getPrizeNames());
        printResult(ladder, players);
    }

    private void printResult(final Ladder ladder, final Players players) {
        Set<Player> playerNames = new HashSet<>(players.getPlayerNames());
        final LadderGameResult ladderGameResult = ladder.findResult();
        while (!playerNames.isEmpty()) {
            readNameAndPrintResult(ladder, ladderGameResult, playerNames);
        }
    }

    private void readNameAndPrintResult(final Ladder ladder, final LadderGameResult ladderGameResult,
                                        final Set<Player> playerNames) {
        String name = inputView.readPlayerNameToCheckPrize();
        if (ladder.isAllResultRequest(name)) {
            outputView.printAllPlayerResult(ladderGameResult.playersPrizeResults());
            playerNames.clear();
            return;
        }
        outputView.printOnePlayerPrize(name, ladderGameResult.getPrize(name));
        playerNames.remove(new Player(name));
    }
}
