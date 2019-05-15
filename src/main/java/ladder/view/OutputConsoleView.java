package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.List;

public class OutputConsoleView {
    //TODO 나중에 getter 안쓰는 혹은 다른 방법 리팩토링
    public static void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        String first = "|";
        String second = "-----";
        String thrid = "     ";
        for (Line line : lines) {
            List<Boolean> subLines = line.getSubLines();
            for (Boolean subLine : subLines) {
                System.out.print(first);
                if (subLine) {
                    System.out.print(second);
                } else {
                    System.out.print(thrid);
                }
            }
            System.out.println(first);
        }

    }
}
