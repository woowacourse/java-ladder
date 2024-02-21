package controller;

import domain.Ladder;
import domain.Participants;
import view.InputView;
import view.OutputView;

public class LadderGame {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static Participants participants;
    private static Ladder ladder;

    public static void main(String[] args) {
        try {
            play();
        } catch (StackOverflowError e) {
            System.out.println("[ERROR] 잘못된 입력의 반복으로 프로그램을 종료합니다.");
        }
    }

    private static void play() {
        participants = recruitParticipants();
        ladder = makeLadder();
        outputView.printResult(participants.getPeopleName(), ladder);
    }

    private static Participants recruitParticipants() {
        try {
            String[] names = inputView.readNames();
            return new Participants(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return recruitParticipants();
        }
    }

    private static Ladder makeLadder() {
        try {
            int height = inputView.readHeight();
            return new Ladder(height, participants.getPeopleCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeLadder();
        }
    }
}
