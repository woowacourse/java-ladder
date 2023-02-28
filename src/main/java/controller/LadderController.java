package controller;

import static view.InputView.DELIMITER;

import domain.Ladder;
import domain.LadderGame;
import domain.LadderResults;
import domain.People;
import domain.Person;
import domain.Prizes;
import domain.RandomLadderGenerator;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        People people = repeat(this::nameRequest);
        Prizes prizes = repeat(() -> prizesRequest(people.getCount()));
        Ladder ladder = repeat(() -> ladderRequest(people.getCount()));
        LadderGame ladderGame = new LadderGame(people, prizes, ladder);

        showGameStatus(people, prizes, ladder);
        ladderGame.start();
        showResult(ladderGame);
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception);
            return repeat(inputReader);
        } catch (Exception exception) {
            outputView.printCriticalError(exception);
            return repeat(inputReader);
        }
    }

    private People nameRequest() {
        String inputNames = inputView.readNames();

        List<String> names = convertToList(inputNames);

        AtomicInteger index = new AtomicInteger();
        List<Person> people = names.stream()
            .map((name) -> new Person(name, index.getAndIncrement()))
            .collect(Collectors.toList());
        return new People(people);
    }

    private List<String> convertToList(String inputs) {
        return Arrays.stream(inputs.split(DELIMITER))
            .collect(Collectors.toList());
    }

    private Prizes prizesRequest(int peopleCount) {
        String inputPrizes = inputView.readResults();

        List<String> prizes = convertToList(inputPrizes);
        return new Prizes(prizes, peopleCount);
    }

    private Ladder ladderRequest(int peopleCount) {
        int height = inputView.readLadderHeight();
        return Ladder.make(peopleCount, height, new RandomLadderGenerator());
    }

    private void showGameStatus(People people, Prizes prizes, Ladder ladder) {
        outputView.printNames(people.getNames());
        outputView.printLadder(ladder);
        outputView.printNames(prizes.getPrizes());
    }

    private void showResult(LadderGame ladderGame) {
        LadderResults result = repeat(() -> getLadderResults(ladderGame));
        outputView.printResult(result);
    }

    private LadderResults getLadderResults(LadderGame ladderGame) {
        String personName = repeat(inputView::readPersonName);
        return ladderGame.searchResult(personName);
    }
}
