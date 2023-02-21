package laddergame.controller;

import java.util.function.Function;
import java.util.function.Supplier;

import laddergame.model.LadderGame;
import laddergame.model.Rewards;
import laddergame.model.Ladder.Height;
import laddergame.model.Ladder.Ladder;
import laddergame.model.Participants;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Participants participants = generate(inputView::readParticipants, Participants::new);
        Rewards rewards = makeExecutionResults(participants);
        Height height = generate(inputView::readLadderHeight, Height::new);
        Ladder ladder = new Ladder(height, participants);
        outputView.printResult(ladder, participants, rewards);
        LadderGame ladderGame = new LadderGame(ladder, rewards, participants);
        printReward(ladderGame);
        inputView.closeScanner();
    }

    private void printReward(LadderGame ladderGame) {
        try{
            String name = inputView.readParticipantWantToSee();
            ladderGame.checkParticipant(name);
            outputView.printReward(ladderGame, name);
        } catch (IllegalArgumentException e) {
            inputView.printErrorMsg(e.getMessage());
            printReward(ladderGame);
        }
    }

    private <T, R> R generate(Supplier<T> supplier, Function<T, R> function) {
        try {
            return function.apply(supplier.get());
        } catch (IllegalArgumentException e) {
            inputView.printErrorMsg(e.getMessage());
            return generate(supplier, function);
        }
    }

    private Rewards makeExecutionResults(Participants participants) {
        try {
            return new Rewards(inputView.readExecutionResults(), participants);
        } catch (IllegalArgumentException e) {
            inputView.printErrorMsg(e.getMessage());
            return makeExecutionResults(participants);
        }
    }
}
