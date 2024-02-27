package controller;

import constant.controller.LadderGameExceptionMessage;
import domain.Ladder;
import domain.Participants;
import domain.Prizes;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderGame {

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
        prizes = decidePrizes(participants.getParticipantsCount());
        ladder = makeLadder();
        outputView.printResult(participants, ladder);
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

    private Prizes decidePrizes(int participantsCount) {
        try {
            List<String> prizes = inputView.readPrizes();
            return new Prizes(prizes, participantsCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return decidePrizes(participantsCount);
        }
    }

    private Ladder makeLadder() {
        try {
            int height = inputView.readHeight();
            return new Ladder(height, participants.getParticipantsCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeLadder();
        }
    }
}
