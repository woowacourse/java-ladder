package laddergame.controller;

import java.util.function.Function;
import java.util.function.Supplier;

import laddergame.model.Ladder.Height;
import laddergame.model.Ladder.Ladder;
import laddergame.model.LadderGame;
import laddergame.model.Participants;
import laddergame.model.Rewards;
import laddergame.view.InputView;
import laddergame.view.OutputView;
import laddergame.view.Power;

public class LadderGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Participants participants = generate(inputView::readParticipants, Participants::new);
        Rewards rewards = makeRewards(participants);
        Height height = generate(inputView::readLadderHeight, Height::new);
        Ladder ladder = new Ladder(height, participants);
        outputView.printResult(ladder, participants, rewards);
        LadderGame ladderGame = new LadderGame(ladder, rewards, participants);
        printReward(ladderGame);
    }

    private <T, R> R generate(Supplier<T> supplier, Function<T, R> function) {
        try {
            return function.apply(supplier.get());
        } catch (IllegalArgumentException e) {
            inputView.printErrorMsg(e.getMessage());
            return generate(supplier, function);
        }
    }

    private Rewards makeRewards(Participants participants) {
        try {
            return new Rewards(inputView.readRewards(), participants);
        } catch (IllegalArgumentException e) {
            inputView.printErrorMsg(e.getMessage());
            return makeRewards(participants);
        }
    }

    private void printReward(LadderGame ladderGame) {
        String name = inputView.readParticipantWantToSee();
        try {
            ladderGame.checkParticipant(name);
        } catch (IllegalArgumentException e) {
            inputView.printErrorMsg(e.getMessage());
            printReward(ladderGame);
        }
        outputView.printReward(ladderGame, name);
        reGame(ladderGame);
    }

    private void reGame(LadderGame ladderGame) {
        Power power = inputView.readReGame();
        if (power == Power.RE_GAME) {
            run();
        } else if (power == Power.PRINT) {
            printReward(ladderGame);
        } else {
            inputView.closeScanner();
        }
    }
}
