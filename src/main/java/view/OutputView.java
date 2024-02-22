package view;

import domain.Bridge;
import domain.Ladder;
import domain.Line;
import java.util.List;

public class OutputView {

    private static final String HORIZON_DELIMITER = "-";
    private static final String VERTICAL_DELIMITER = "|";
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";


    public void printPlayer(List<String> names) {
        System.out.println("실행 결과");
        System.out.println();
        names.forEach(name -> {
            System.out.print(String.format("%6s", name));
        });
        System.out.println();
    }

    public void printLadder(Ladder ladder, int maxPlayerNameLength, int length) {
        List<Line> lines = ladder.getLines();

        for (Line line : lines) {
            System.out.print(SPACE.repeat(length));
            System.out.print(VERTICAL_DELIMITER);
            for (Bridge bridge : line.getBridges()) {
                if (bridge == Bridge.EXIST) {
                    System.out.print(HORIZON_DELIMITER.repeat(maxPlayerNameLength));
                    System.out.print(VERTICAL_DELIMITER);
                    continue;
                }
                System.out.print(SPACE.repeat(maxPlayerNameLength));
                System.out.print(VERTICAL_DELIMITER);
            }
            System.out.println();
        }
    }
}
