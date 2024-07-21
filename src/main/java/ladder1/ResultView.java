package ladder1;

import java.util.List;

public class ResultView {

    public void printParticipants(List<String> participants) {
    	System.out.print("     ");
        for (String person : participants) {
            Person p = new Person(person);
            System.out.print(p.getFormattedName() + " ");
        }
        System.out.println();
    }

    public void printLadder(List<String> ladder) {
        System.out.print("     |");
        for (String line : ladder) {
            System.out.print(line + "|");
        }
        System.out.println();
    }
}
