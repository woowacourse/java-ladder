package ladder.view;

import ladder.domain.LadderRow;

import java.util.List;

public class OutputView {


    public OutputView() {
    }

    public String print(LadderRow row) {
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
        if (number == 1) {
            return "-----";
        }
        return "     ";
    }
}
