package controller;

import static view.InputView.DELIMITER;

import domain.Ladder;
import domain.People;
import domain.Person;
import domain.RandomLadderGenerator;
import java.util.Arrays;
import java.util.List;
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
        Ladder ladder = repeat(() -> ladderRequest(people.getCount()));

        outputView.printNames(people.getNames());
        outputView.printLadder(ladder);
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
        List<Person> people = names.stream()
            .map(Person::new)
            .collect(Collectors.toList());
        return new People(people);
    }

    private List<String> convertToList(String inputNames) {
        return Arrays.stream(inputNames.split(DELIMITER))
            .collect(Collectors.toList());
    }

    private Ladder ladderRequest(int peopleCount) {
        int height = inputView.readLadderHeight();
        return Ladder.make(peopleCount, height, new RandomLadderGenerator());
    }
}
