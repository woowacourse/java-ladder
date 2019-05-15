package ladder.view;

import ladder.domain.LadderRow;

import java.util.Iterator;
import java.util.List;

public class OutputView {


    public OutputView() {
    }

    public String print(LadderRow row) {
        List<Integer> info = row.status();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < info.size() - 1; i++) {
            stringBuilder.append("|");
            if (info.get(i) == 1) {
                for (int j = 0; j < 5; j++) {
                    stringBuilder.append("-");
                }
            } else {
                for (int j = 0; j < 5; j++) {
                    stringBuilder.append(" ");
                }
            }
        }

        stringBuilder.append("|");
//
//        for (Integer integer : info) {
//
//
//            stringBuilder.append("|");
//            if (integer == 1) {
//                for (int i = 0; i < 5; i++) {
//                    stringBuilder.append("-");
//                }
//            } else {
//                for (int i = 0; i < 5; i++) {
//                    stringBuilder.append(" ");
//                }
//            }
//
//        }
        return stringBuilder.toString();
    }
}
