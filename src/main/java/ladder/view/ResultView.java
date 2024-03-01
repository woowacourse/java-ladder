package ladder.view;

import java.util.Map.Entry;

public class ResultView {
    public static void printAll(Result result) {
        System.out.println(System.lineSeparator() + "실행 결과");
        for (Entry<String, String> entry : result.getResultMap().entrySet()) {
            System.out.printf("%s : %s" + System.lineSeparator(),
                    entry.getKey(),
                    entry.getValue());
        }
    }

    public static void printResultOf(String name, Result result) {
        System.out.println(System.lineSeparator() + "실행 결과");
        if (result.getResultMap().containsKey(name)) {
            System.out.println(result.getResultMap().get(name));
            return;
        }
        System.out.println("존재하지 않는 이름입니다.");
    }
}
