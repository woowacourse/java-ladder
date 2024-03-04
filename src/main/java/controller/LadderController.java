package controller;

import static common.ReservedKeywords.ALL;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import domain.booleanGenerator.BooleanGenerator;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladderGame.LadderGame;
import domain.player.Name;
import domain.player.Player;
import domain.player.Players;
import domain.prize.Prize;
import domain.prize.Prizes;
import java.util.List;
import java.util.stream.IntStream;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final BooleanGenerator booleanGenerator;

    public LadderController(BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public void run() {
        try {
            final Players players = generatePlayers();
            final Prizes prizes = generatePrizes(players.getPlayerCount());
            final Height height = generateHeight();
            final Ladder ladder = generateLadder(players, height);

            final LadderGame ladderGame = new LadderGame(ladder, players);
            ladderGame.play();

            OutputView.printLadderResult(players, prizes, ladder);
            takeUserInputAndFindResult(players, prizes);
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
        }
    }

    private Players generatePlayers() {
        final List<String> names = InputView.inputPlayerNames();

        final List<Player> players = IntStream.range(0, names.size())
                .mapToObj(index -> new Player(new Name(names.get(index)), index))
                .toList();

        return new Players(players);
    }

    private Prizes generatePrizes(final int playerCount) {
        final List<String> rawPrizes = InputView.inputPrizes();
        return rawPrizes.stream()
                .map(Prize::new)
                .collect(collectingAndThen(toList(), prizes -> new Prizes(prizes, playerCount)));
    }

    private Height generateHeight() {
        final int height = InputView.inputHeight();
        return new Height(height);
    }

    private Ladder generateLadder(Players players, Height height) {
        return new Ladder(booleanGenerator, height, players.getPlayerCount());
    }

    private static void takeUserInputAndFindResult(final Players players, final Prizes prizes) {
        String targetName;
        do {
            targetName = InputView.inputPrizeTargetName();
            OutputView.printResult(players, prizes, targetName);
        } while (!ALL.equals(targetName));
    }
}
