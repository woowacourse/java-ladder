package controller;

import constant.Exception;
import domain.Ladder;
import domain.Participants;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderGame {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static Participants participants;
    private static Ladder ladder;

    public static void main(String[] args) {
        try {
            play();
        } catch (StackOverflowError e) {
            System.out.println(Exception.EXIT.getExceptionMessage());
        }
    }

    private static void play() {
        participants = recruitParticipants();
        ladder = makeLadder();
        outputView.printResult(participants.getParticipantsName(), ladder);
    }

    private static Participants recruitParticipants() {
        try {
            List<String> names = inputView.readNames();
            return new Participants(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return recruitParticipants();
        }
    }

    private static Ladder makeLadder() {
        try {
            int height = inputView.readHeight();
            return new Ladder(height, participants.getParticipantsCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeLadder();
        }
    }
}
