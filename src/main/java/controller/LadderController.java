package controller;

import domain.model.consequence.Consequences;
import domain.model.ladder.Ladder;
import domain.model.ladder.LadderGame;
import domain.model.ladder.Result;
import domain.model.participant.People;
import domain.model.participant.Person;
import handler.ExceptionHandler;
import utils.RuleGeneratorImpl;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.function.Supplier;

public class LadderController {

    private final ResultView resultView = new ResultView();
    private final InputView inputView = new InputView();
    private final ExceptionHandler handler = new ExceptionHandler();
    private final People people;
    private final Consequences consequences;
    private final Ladder ladder;

    public LadderController() {
        this.people = registerPeople();
        this.consequences = registerConsequences();
        this.ladder = makeLadder();
    }

    public void execute() {
        resultView.printLadderGame(people, ladder, consequences);
        Result result = playGame();
        showResult(result);
    }

    private void showResult(Result result) {
        String chosen = askChosen();
        if (chosen.equals("all")) {
            resultView.printAll(result);
            return;
        }
        resultView.printResult(result, new Person(chosen));
        showResult(result);
    }

    private Result playGame() {
        LadderGame ladderGame = new LadderGame(ladder, people, consequences);
        ladderGame.play();
        return ladderGame.giveResult();
    }

    private String askChosen() {
        Supplier<String> chosenSupplier = () -> {
            String chosen = inputView.askChosen();
            return people.findProperParticipant(chosen);
        };
        return registerWithRetry(chosenSupplier);
    }

    private Ladder makeLadder() {
        Supplier<Ladder> ladderSupplier = () -> {
            String height = inputView.askLadderHeight();
            return new Ladder(height, people.getNumberOfParticipants(), new RuleGeneratorImpl());
        };
        return registerWithRetry(ladderSupplier);
    }

    private People registerPeople() {
        Supplier<People> peopleSupplier = () -> {
            List<String> participants = inputView.askParticipants();
            return new People(participants);
        };
        return registerWithRetry(peopleSupplier);
    }

    private Consequences registerConsequences() {
        Supplier<Consequences> consequencesSupplier = () -> {
            List<String> consequences = inputView.askConsequences();
            return new Consequences(consequences, people.getNumberOfParticipants());
        };
        return registerWithRetry(consequencesSupplier);
    }


    public <T> T registerWithRetry(Supplier<T> callback) {
        return handler.handle(callback);
    }
}
