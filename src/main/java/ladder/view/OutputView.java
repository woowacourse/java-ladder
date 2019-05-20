package ladder.view;

import ladder.domain.DrawnLadder;
import ladder.domain.Position;

public class OutputView {

    public static void printDrawnLadder(DrawnLadder drawnLadder) {
        String verticalLine = "|";
        String horizontalLine = "-----";
        String emptyHorizontalLine = "     ";

        System.out.println("사다리 출력");
        for (Position r : drawnLadder.createFirstRowPosition().begin()) {
            System.out.print(emptyHorizontalLine);
            System.out.print(verticalLine);
            for (Position c : drawnLadder.createFirstLeftColumnPosition().begin()) {
                System.out.print(drawnLadder.isDrawn(r, c) ? horizontalLine : emptyHorizontalLine);
                System.out.print(verticalLine);
            }
            System.out.print("\n");
        }
    }
}
