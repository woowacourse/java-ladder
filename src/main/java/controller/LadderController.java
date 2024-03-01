package controller;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import domain.booleanGenerator.BooleanGenerator;
import domain.ladder.Height;
import domain.ladder.Ladder;
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
            final Prizes prizes = generatePrizes();
            final Height height = generateHeight();
            final Ladder ladder = generateLadder(players, height);

            ladder.play(players);

            OutputView.printPlayerNames(players);
            OutputView.printLadder(ladder, players.findMaxNameLength());
            OutputView.printPrizes(prizes);

            final String targetName = InputView.inputPrizeTargetName();
            final Prize resultByPlayer = prizes.findResultByPlayer(players.findPlayerByName(targetName));
            OutputView.printGamePrize(resultByPlayer.getValue());
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

    private Prizes generatePrizes() {
        final List<String> prizes = InputView.inputPrizes();
        return prizes.stream()
                .map(Prize::new)
                .collect(collectingAndThen(toList(), Prizes::new));
    }

    private Height generateHeight() {
        final int height = InputView.inputHeight();
        return new Height(height);
    }

    private Ladder generateLadder(Players players, Height height) {
        return new Ladder(booleanGenerator, height, players.getPlayerCount());
    }
}
