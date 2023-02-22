package application;

import static java.util.stream.Collectors.toList;

import domain.LadderResultRequest;
import domain.ladder.Ladder;
import domain.ladder.LadderGenerator;
import domain.ladder.LadderHeight;
import domain.player.Name;
import domain.player.Player;
import domain.player.Players;
import dto.PlayerLadderResult;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class LadderGameApplication {

    private final InputView inputView;
    private final OutputView outputView;
    private final LadderGenerator ladderGenerator;

    public LadderGameApplication(InputView inputView, OutputView outputView, LadderGenerator ladderGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderGenerator = ladderGenerator;
    }

    public void run() {
        Players players = retryIfError(this::createPlayers);
        LadderHeight ladderHeight = retryIfError(inputView::readLadderHeight);
        List<String> ladderResults = retryIfError(inputView::readLadderResults);

        Ladder ladder = ladderGenerator.generate(players.size(), ladderHeight, ladderResults);
        outputView.printLadder(players, ladder);

        while (true) {
            LadderResultRequest request = inputView.readSpecificResult();

            if (request.isAll()) {
                List<PlayerLadderResult> everyPlayerResult = getEveryPlayerResult(players, ladder);
                outputView.printEveryPlayerResult(everyPlayerResult);
                break;
            }

            if (request.isPlayerName(players)) {
                outputView.printNoMatchingPlayerMessage(request);
                continue;
            }

            Player findPlayer = players.findSpecificNamePlayer(request.getMessage());
            String singlePlayerResult = ladder.play(findPlayer.getPosition());
            outputView.printSinglePlayerResult(singlePlayerResult);
        }
    }

    private <T> T retryIfError(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Players createPlayers() {
        List<Name> names = inputView.readNames();

        List<Player> players = new ArrayList<>();
        for (int idx = 0; idx < names.size(); idx++) {
            players.add(new Player(names.get(idx), idx + 1));
        }

        return new Players(players);
    }

    private List<PlayerLadderResult> getEveryPlayerResult(Players players, Ladder ladder) {
        return players.stream()
                .map(player -> {
                    String result = ladder.play(player.getPosition());
                    return new PlayerLadderResult(player.getName(), result);
                })
                .collect(toList());
    }
}
