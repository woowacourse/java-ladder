package controller;

import domain.Ladder;
import domain.Participants;
import view.InputView;

import java.util.List;

public class LadderGame {

    private final InputView inputView;

    public LadderGame(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        Participants participants = makeParticipants(inputName());
        Ladder ladder = new Ladder(inputHeight());
    }

    private List<String> inputName() {
        String input = inputView.inputName();

        return List.of(input.split(","));
    }

    private Participants makeParticipants(List<String> names) {
        return new Participants(names);
    }

    private String inputHeight() {
        return inputView.inputHeight();
    }
}
