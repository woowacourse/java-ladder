package view;

import domain.Floor;
import domain.Floors;
import domain.Name;
import java.util.List;

public class OutputView {

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void printResult(List<Name> names, Floors floors) {
        System.out.println(Message.OUTPUT_RESULT.message);
        names.forEach(name -> System.out.printf("%-5s", name.getName()));
        System.out.println();
        printLadder(floors);
    }

    public void printLadder(Floors floors) {
        for (Floor floor : floors.getFloors()) {
            StringBuilder result = new StringBuilder();
            result.append(Message.COLUMN_LADDER.message);
            floor.getPoints()
                    .forEach(isPoint -> result.append(getPointString(isPoint)));
            System.out.println(result);
        }
    }

    private String getPointString(boolean isPoint) {
        if (isPoint) {
            return Message.ROW_LADDER.message;
        }
        return Message.EMPTY_ROW_LADDER.message;
    }

    private enum Message {
        OUTPUT_RESULT("실행결과\n"),
        COLUMN_LADDER("  |"),
        ROW_LADDER("-----|"),
        EMPTY_ROW_LADDER("     |");;

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
