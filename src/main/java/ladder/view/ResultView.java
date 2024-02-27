package ladder.view;

import ladder.view.enums.Command;

import java.util.Map.Entry;

import static ladder.view.enums.Command.PRINT_ALL;
import static ladder.view.enums.Command.STOP;

public class ResultView {
    public static boolean retry = true;

    public static void print(String name, Result result) {
        if (!Command.contains(name)) {
            printResult(name, result);
        }
        if (STOP.isSameWith(name)) {
            retry = false;
        }
        if (PRINT_ALL.isSameWith(name)) {
            printAll(result);
        }
    }

    public static boolean isRetry() {
        return retry;
    }

    private static void printAll(Result result) {
        System.out.println(System.lineSeparator() + "실행 결과");
        for (Entry<String, String> entry : result.getResultMap().entrySet()) {
            System.out.printf("%s : %s" + System.lineSeparator(),
                    entry.getKey(),
                    entry.getValue());
        }
    }

    private static void printResult(String name, Result result) {
        System.out.println(System.lineSeparator() + "실행 결과");
        if (result.getResultMap().containsKey(name)) {
            System.out.println(result.getResultMap().get(name));
            return;
        }
        System.out.println("존재하지 않는 이름입니다.");
    }
}
