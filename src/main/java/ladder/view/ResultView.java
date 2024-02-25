package ladder.view;

import java.util.Map.Entry;

public class ResultView {
    private static final String COMMAND_ALL = "all";

    public static void print(String name, Result result) {
        System.out.println("실행 결과");
        if (name.equals(COMMAND_ALL)) {
            printAll(result);
            return;
        }
        printResult(name, result);
    }

    private static void printResult(String name, Result result) {
        if (result.getResultMap().containsKey(name)) {
            System.out.println(result.getResultMap().get(name));
            return;
        }
        System.out.println("존재하지 않는 이름입니다.");
    }

    private static void printAll(Result result) {
        for (Entry<String, String> entry : result.getResultMap().entrySet()) {
            System.out.printf("%s : %s"+System.lineSeparator(),
                    entry.getKey(),
                    entry.getValue());
        }
    }
}
