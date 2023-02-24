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
        Results results = createResults(names);
        LadderHeight ladderHeight = createLadderHeight(names.size());
        Ladder ladder = Ladder.of(names.size(), ladderHeight, numberGenerator);
        LadderGame ladderGame = LadderGame.of(names, ladder, results);

        outputView.printCreatedLadderGame(names, ladder, results);
        showResultByCommandOrName(ladderGame);
    }

    private Names createNames() {
        try {
            List<String> userInput = inputView.readNames();
            return userInput.stream()
                    .map(Name::new)
                    .collect(collectingAndThen(toList(), Names::new));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return createNames();
        }
    }

    private Results createResults(Names names) {
        try {
            List<String> userInput = inputView.readResults();
            return new Results(userInput.stream()
                    .map(Result::new)
                    .collect(Collectors.toList()), names);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return createResults(names);
        }
    }

    private LadderHeight createLadderHeight(int numberOfPeople) {
        try {
            int userInput = inputView.readLadderHeight();
            return new LadderHeight(userInput, numberOfPeople);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return createLadderHeight(numberOfPeople);
        }
    }

    private void showResultByCommandOrName(LadderGame ladderGame) {
        String userInput = inputView.readCommandOrName();
        if (userInput.equals("all")) {
            outputView.printAllResult(ladderGame.getAllNames(), ladderGame.getAllResults());
            return;
        }
        showResultByName(ladderGame, userInput);
        showResultByCommandOrName(ladderGame);
    }

    private void showResultByName(LadderGame ladderGame, String name) {
        try {
            outputView.printOneResult(ladderGame.getResultOf(name));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }
}
