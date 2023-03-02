package controller;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import domain.Ladder;
import domain.LadderGame;
import domain.LadderHeight;
import domain.Line;
import domain.Name;
import domain.Player;
import domain.Players;
import domain.Position;
import domain.Result;
import domain.Results;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import utils.NumberGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public LadderController(InputView inputView,
                            OutputView outputView,
                            NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        Players players = createPlayers();
        Results results = createResults(players);
        LadderHeight ladderHeight = createLadderHeight(players.size());
        Ladder ladder = Ladder.of(players.size(), ladderHeight, numberGenerator);
        LadderGame ladderGame = new LadderGame(ladder, results);
        outputView.printCreatedLadderGame(
                players.stream().map(player -> player.name().value()).collect(Collectors.toList()),
                ladder.lines().stream().map(Line::points).collect(toList()),
                results.stream().map(Result::value).collect(toList()));
        showResultByCommandOrName(players, ladderGame);
    }

    private Players createPlayers() {
        try {
            List<String> rawNames = inputView.readNames();
            AtomicInteger index = new AtomicInteger();
            return rawNames.stream()
                    .map(name -> new Player(new Name(name), new Position(index.getAndIncrement())))
                    .collect(collectingAndThen(toList(), Players::new));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return createPlayers();
        }
    }

    private Results createResults(Players players) {
        try {
            List<String> rawResults = inputView.readResults();
            return new Results(rawResults.stream()
                    .map(Result::new)
                    .collect(Collectors.toList()), players);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return createResults(players);
        }
    }

    private LadderHeight createLadderHeight(int numberOfPeople) {
        try {
            int rawLadderHeight = inputView.readLadderHeight();
            return new LadderHeight(rawLadderHeight, numberOfPeople);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return createLadderHeight(numberOfPeople);
        }
    }

    private void showResultByCommandOrName(Players players, LadderGame ladderGame) {
        String commandOrName = inputView.readCommandOrName();
        if (commandOrName.equals("all")) {
            Map<String, String> allNamesAndResults = players.stream()
                    .collect(toMap(player -> player.name().value(), player -> ladderGame.getResultOf(player).value()));
            outputView.printAllNamesAndResults(allNamesAndResults);
            return;
        }
        showResultByName(players, ladderGame, commandOrName);
        showResultByCommandOrName(players, ladderGame);
    }

    private void showResultByName(Players players, LadderGame ladderGame, String name) {
        try {
            Player player = players.getPlayerByName(name);
            outputView.printOneResult(ladderGame.getResultOf(player).value());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }
}
