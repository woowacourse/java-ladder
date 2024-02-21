package view;

import domain.Direction;
import domain.Ladder;
import domain.Line;
import domain.Point;
import java.util.List;

public class OutputView {

    public void printPlayer(List<String> names) {
        System.out.println("실행 결과");
        System.out.println();
        names.forEach(name -> {
            System.out.print(name);
            System.out.print("   ");
        });
        System.out.println();
    }

    public void printLadder(Ladder ladder, int maxPlayerNameLength, int length) {
        List<Line> lines = ladder.getLines();
        StringBuffer sb = new StringBuffer();
        for (Line line : lines) {
            sb.append(" ".repeat(length));
            for (Point point : line.getPoints()) {
                sb.append("|");
                if (point.getDirection() == Direction.RIGHT) {
                    sb.append("-".repeat(maxPlayerNameLength));
                    continue;
                }
                sb.append(" ".repeat(maxPlayerNameLength));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
