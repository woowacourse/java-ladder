package controller;

import constant.controller.LadderGameExceptionMessage;
import domain.Ladder;
import domain.Participants;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderGame {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Participants participants;
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
        ladder = makeLadder();
        outputView.printResult(participants.getParticipantsName(), ladder);
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
