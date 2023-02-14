package laddergame.controller;

import laddergame.model.Persons;
import laddergame.view.InputView;

public class LadderGameController {
    InputView inputView = new InputView();

    public void run() {
        makePersons();
    }

    private void makePersons() {
        try {
            Persons persons = new Persons(inputView.readPersonNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            makePersons();
        }
    }
}
