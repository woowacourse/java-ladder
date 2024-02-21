package controller;

import model.Ladder;
import model.LadderRow;
import model.Participant;
import view.InputView;
import view.OutputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() throws IOException {
        List<Participant> participants = inputView.inputParticipantsName().stream().map(Participant::new).toList();
        int height = inputView.inputLadderHeight();
        Ladder ladder = new Ladder(height, makeLadderRows(height, participants.size()));
        ladder.createRows();
        outputView.printResult();
        outputView.printParticipantsName(participants);
        outputView.printLadder(ladder);
    }

    private List<LadderRow> makeLadderRows(int height, int participantsSize){
        List<LadderRow> emptyLadderRows = new ArrayList<>();
        for(int i = 0; i < height; i++){
            emptyLadderRows.add(new LadderRow(participantsSize));
        }
        return new ArrayList<>(emptyLadderRows);
    }
}
