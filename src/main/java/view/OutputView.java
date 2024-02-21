package view;

import model.Ladder;
import model.LadderRow;
import model.Participant;

import java.util.List;

public class OutputView {

    public void printResult() {
        System.out.println("실행결과\n");
    }

    public void printParticipantsName(List<Participant> participants) {
        List<String> participantsName = participants.stream().map(participant -> checkNameLength(participant.getName())).toList();
        participantsName.forEach(System.out::print);
        System.out.println();
    }

    private String checkNameLength(String name) {
        int nameLength = name.length();
        if (nameLength == 5) {
            return name + " ";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ".repeat(4 - nameLength));
        stringBuilder.append(name).append("  ");
        return stringBuilder.toString();
    }

    public void printLadder(Ladder ladder) {
        for(int i = 0; i < ladder.height(); i++){
            printRow(ladder.getRow(i));
            System.out.println();
        }
    }

    private void printRow(LadderRow ladderRow){
        for (boolean line : ladderRow.getLines()){
            System.out.print(LadderStructure.DIVISION.getOutput());
            System.out.print(LadderStructure.match(line).getOutput());
        }
        System.out.print(LadderStructure.DIVISION.getOutput());
    }

}
