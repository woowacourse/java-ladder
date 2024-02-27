package controller;

import domain.Ladder;
import domain.LadderResult;
import domain.Participants;
import domain.Prizes;
import exception.controller.LadderGameExceptionMessage;
import exception.view.InputExceptionMessage;
import java.util.List;
import java.util.stream.IntStream;
import utils.RandomStepGenerator;
import view.InputView;
import view.OutputView;

public class LadderGame {

    public static final String EXIT = "종료";
    public static final String ALL = "all";
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Participants participants;
    private Prizes prizes;
    private Ladder ladder;

    public void play() {
        try {
            run();
        } catch (StackOverflowError e) {
            System.out.println(LadderGameExceptionMessage.EXIT.getExceptionMessage());
        }
    }

    private void run() {
        participants = recruitParticipants();
        prizes = decidePrizes();
        ladder = makeLadder();
        outputView.printResult(participants, ladder, prizes);
        result();
    }

    private Participants recruitParticipants() {
        try {
            List<String> names = inputView.readNames();
            return new Participants(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return recruitParticipants();
        }
    }

    private Prizes decidePrizes() {
        try {
            List<String> prizes = inputView.readResults();
            return new Prizes(prizes, participants);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return decidePrizes();
        }
    }

    private Ladder makeLadder() {
        try {
            int height = inputView.readHeight();
            return new Ladder(height, participants.getParticipantsCount(), new RandomStepGenerator());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeLadder();
        }
    }

    private void result() {
        try {
            String name = inputView.readResultName();
            validateResultName(name);
            checkResult(name);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            result();
        }
    }

    private void checkResult(String name) {
        LadderResult ladderResult = new LadderResult(ladder, participants.getParticipantsCount());
        if (name.equals(EXIT)) {
            return;
        }
        if (name.equals(ALL)) {
            checkAllResult(ladderResult);
            return;
        }
        checkOneResult(name, ladderResult);
    }

    private void checkAllResult(LadderResult ladderResult) {
        outputView.printAllResult(ladderResult, participants, prizes);
        result();
    }

    private void checkOneResult(String name, LadderResult ladderResult) {
        int firstPosition = IntStream.range(0, participants.getParticipantsCount())
                .filter(i -> participants.getParticipantsName().get(i).getName().equals(name))
                .findFirst()
                .getAsInt();
        outputView.printOneResult(ladderResult, prizes, firstPosition);
        result();
    }

    private void validateResultName(String name) {
        if (!name.equals(EXIT) && !name.equals(ALL) && !participants.hasParticipated(name)) {
            throw new IllegalArgumentException(InputExceptionMessage.NO_PARTICIPANTS.getExceptionMessage());
        }
    }
}
