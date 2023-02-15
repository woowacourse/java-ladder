package laddergame.controller;

import laddergame.model.Height;
import laddergame.model.Persons;
import laddergame.view.InputView;

public class LadderGameController {
    InputView inputView = new InputView();

    public void run() {
        makePersons();
        makeLadderHeight();
    }

    private void makePersons() {
        try {
            Persons persons = new Persons(inputView.readPersonNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            makePersons();
        }
    }

    private void makeLadderHeight() {
        try {
            Height height = new Height(inputView.readLadderHeight());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            makeLadderHeight();
        }
    }
}
