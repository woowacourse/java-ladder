package ladder.view;

import ladder.model.LadderGame;
import ladder.model.Member;
import ladder.model.Row;

public class OutputView {
    public static void printLadder(LadderGame ladderGame) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Member member : ladderGame.getMembers()) {
            stringBuilder.append(makePrettyName(member.getName()) + " ");
        }
        stringBuilder.append("\n");
        for (Row row : ladderGame.getLadder()){
            stringBuilder.append(row.toString() + "\n");
        }
        System.out.println(stringBuilder.toString());
    }

    private static String makePrettyName(String name){
        StringBuilder stringBuilder = new StringBuilder();
        int blankLength = 5 - name.length();
        stringBuilder.append(name);
        for (int i = 1; i <= blankLength; i++){
            addBlank(stringBuilder, i);
        }
        return stringBuilder.toString();
    }

    private static void addBlank(StringBuilder stringBuilder, int i) {
        if (i % 2 == 0){
            stringBuilder.append(" ");
        }
        if (i % 2 == 1){
            stringBuilder.insert(0, " ");
        }
    }
}
