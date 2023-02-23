package controller;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import domain.Ladder;
import domain.LadderGame;
import domain.LadderHeight;
import domain.Name;
import domain.Names;
import domain.Result;
import domain.Results;
import java.util.List;
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
        Names names = createNames();
        Results results = createResults(names.size());
        LadderHeight ladderHeight = createLadderHeight();
        Ladder ladder = Ladder.create(names.size(), ladderHeight, numberGenerator);
        LadderGame ladderGame = new LadderGame(names, ladder, results);

        outputView.printCreatedLadderGame(names, ladder, results);
        showResultByCommandOrName(ladderGame);
    }

    private Names createNames() {
        try {
            List<String> rawNames = inputView.readNames();
            return rawNames.stream()
                    .map(Name::new)
                    .collect(collectingAndThen(toList(), Names::new));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return createNames();
        }
    }

    private Results createResults(int numberOfPeople) {
        try {
            List<String> rawResults = inputView.readResults();
            return new Results(rawResults.stream()
                    .map(Result::new)
                    .collect(Collectors.toList()), numberOfPeople);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return createResults(numberOfPeople);
        }
    }

    private LadderHeight createLadderHeight() {
        try {
            int height = inputView.readLadderHeight();
            return new LadderHeight(height);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return createLadderHeight();
        }
    }

    private void showResultByCommandOrName(LadderGame ladderGame) {
        String command = inputView.readCommand();
        if (command.equals("all")) {
            outputView.printAllResult(ladderGame.getAllParticipants(), ladderGame.getAllResult());
            return;
        }
        showResultByName(ladderGame, command);
        showResultByCommandOrName(ladderGame);
    }

    private void showResultByName(LadderGame ladderGame, String command) {
        try {
            outputView.printOneResult(ladderGame.getResultOf(command));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }
}
