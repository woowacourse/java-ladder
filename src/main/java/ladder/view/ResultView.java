package ladder.view;

import java.util.Map.Entry;

import static ladder.view.enums.Command.PRINT_ALL;
import static ladder.view.enums.Command.STOP;

public class ResultView {
    public static boolean print(String name, Result result) {
        System.out.println(System.lineSeparator() + "실행 결과");
        if (PRINT_ALL.isSameWith(name)) {
            printAll(result);
            return true;
        }
        if (STOP.isSameWith(name)) {
            return false;
        }
        printResult(name, result);
        return true;
    }

    private static void printAll(Result result) {
        for (Entry<String, String> entry : result.getResultMap().entrySet()) {
            System.out.printf("%s : %s" + System.lineSeparator(),
                    entry.getKey(),
                    entry.getValue());
        }
    }

    private static void printResult(String name, Result result) {
        if (result.getResultMap().containsKey(name)) {
            System.out.println(result.getResultMap().get(name));
            return;
        }
        System.out.println("존재하지 않는 이름입니다.");
    }
}
