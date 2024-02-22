package view;

import model.Ladder;
import model.LadderRow;
import model.Participant;
import model.Participants;

import java.util.List;

public class OutputView {

    public void printResult() {
        System.out.println("실행결과\n");
    }

    public void printParticipantsName(Participants participants) {
        List<String> participantsName = participants.getParticipants().stream()
                .map(Participant::getName)
                .toList();
        participantsName.forEach(name -> System.out.print(String.format("%5s ", name)));
        System.out.println();
    }

    public void printLadder(Ladder ladder) {
        for(int i = 0; i < ladder.height(); i++){
            printRow(ladder.getRow(i));
            System.out.println();
        }
    }

    private void printRow(LadderRow ladderRow){
        System.out.print(LadderComponent.EMPTY_LINE);
        for (boolean line : ladderRow.getLineStatus()){
            System.out.print(LadderComponent.DIVISION.getOutput());
            System.out.print(LadderComponent.match(line).getOutput());
        }
        System.out.print(LadderComponent.DIVISION.getOutput());
    }

}
