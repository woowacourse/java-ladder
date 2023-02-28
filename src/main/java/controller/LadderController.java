package controller;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import domain.Ladder;
import domain.LadderGame;
import domain.LadderHeight;
import domain.Line;
import domain.Name;
import domain.Names;
import domain.Result;
import domain.Results;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
        outputView.printCreatedLadderGame(
                names.getValues().stream().map(Name::value).collect(toList()),
                ladder.getValues().stream().map(Line::points).collect(toList()),
                results.getValues().stream().map(Result::value).collect(toList()));
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

    private Results createResults(Names names) {
        try {
            List<String> rawResults = inputView.readResults();
            return new Results(rawResults.stream()
                    .map(Result::new)
                    .collect(Collectors.toList()), names);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return createResults(names);
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

    private void showResultByCommandOrName(LadderGame ladderGame) {
        String commandOrName = inputView.readCommandOrName();
        if (commandOrName.equals("all")) {
            Map<String, String> allNamesAndResults = getAllNamesAndResults(ladderGame);
            outputView.printAllNamesAndResults(allNamesAndResults);
            return;
        }
        showResultByName(ladderGame, commandOrName);
        showResultByCommandOrName(ladderGame);
    }

    private Map<String, String> getAllNamesAndResults(LadderGame ladderGame) {
        Map<Name, Result> allNamesAndResults = ladderGame.getAllNamesAndResults();
        Map<String, String> rawAllNamesAndResults = new LinkedHashMap<>();
        allNamesAndResults.forEach((name, result) -> rawAllNamesAndResults.put(name.value(), result.value()));
        return rawAllNamesAndResults;
    }

    private void showResultByName(LadderGame ladderGame, String name) {
        try {
            outputView.printOneResult(ladderGame.getResultOf(name).value());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }
}
