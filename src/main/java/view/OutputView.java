package view;

import java.util.List;
import model.LadderElement;
import model.Line;
import view.dto.LadderResponse;

public class OutputView {
    public void printResult(List<String> names, LadderResponse ladderResponse) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();
        printPlayers(names);
        printLadder(ladderResponse);
    }

    private void printPlayers(List<String> names) {
        StringBuilder stringBuilder = new StringBuilder();
        String firstPlayer = names.get(0);

        stringBuilder.append(firstPlayer);
        stringBuilder.append(" ".repeat(5 - firstPlayer.length()));

        for (String name : names.subList(1, names.size() - 1)) {
            stringBuilder.append(" ".repeat(6 - name.length()));
            stringBuilder.append(name);
        }

        String lastPlayer = names.get(names.size() - 1);

        stringBuilder.append(" ".repeat(5 - lastPlayer.length()));
        stringBuilder.append(lastPlayer);

        System.out.println(stringBuilder);
    }

    private void printLadder(LadderResponse ladderResponse) {
        List<Line> lines = ladderResponse.getLadder();
        for (Line line : lines) {
            StringBuilder stringBuilder = new StringBuilder();

            int paddingSize = ladderResponse.getPaddingSize();
            stringBuilder.append(" ".repeat(paddingSize));

            stringBuilder.append(LadderElement.COLUMN.getSymbol());

            List<Boolean> points = line.getPoints();
            for(boolean point : points) {
                stringBuilder.append(getElement(point));
                stringBuilder.append(LadderElement.COLUMN.getSymbol());

            }
            System.out.println(stringBuilder);
        }
    }

    private String getElement(boolean point) {
        if(point) {
            return LadderElement.ROW.getSymbol();
        }
        return LadderElement.EMPTY.getSymbol();
    }
}
