package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderRow;
import ladder.domain.LadderRules;

import java.util.List;

public class OutputView {


    public OutputView() {
    }

    public void print(LadderRow row) {
        System.out.println(ConsoleMessages.OUTPUT_LADDER.message());
        System.out.println(line(row));
    }


    public void print(Ladder ladder) {
        System.out.println(ConsoleMessages.OUTPUT_LADDER.message());

        List<LadderRow> rows = ladder.status();
        for (int i = 0; i < rows.size(); i++) {
            System.out.println(line(rows.get(i)));
        }

    }

    public String line(LadderRow row) {
        List<Integer> info = row.status();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < info.size() - 1; i++) {
            stringBuilder.append("|");
            stringBuilder.append(mark(info.get(i)));
        }

        stringBuilder.append("|");
        return stringBuilder.toString();
    }


    private String mark(Integer number) {
        if (number == LadderRules.RIGHT.number()) {
            return "-----";
        }
        return "     ";
    }
}
