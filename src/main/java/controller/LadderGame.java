package controller;

import domain.Ladder;
import domain.Participants;
import view.InputView;
import view.OutputView;

public class LadderGame {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        play();
    }

    private static void play() {
        String[] names = inputView.readNames();
        int height = inputView.readHeight();
        Participants participants = new Participants(names);
        Ladder ladder = new Ladder(height, participants.getPeopleCount());
        outputView.printResult(participants.getPeopleName(), ladder);
    }
}
