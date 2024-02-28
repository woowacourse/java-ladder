package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import ladder.domain.Height;
import ladder.domain.LadderResult;
import ladder.domain.LadderResults;
import ladder.domain.Players;
import ladder.exception.ExceptionHandler;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private final ExceptionHandler exceptionHandler;

    public InputView(final ExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    public Players inputNames() {
        return exceptionHandler.run(() -> {
            System.out.println("\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            List<String> names = Arrays.asList(readLine().split(","));
            return new Players(names);
        });
    }

    public LadderResults inputLadderResults(Players players) {
        return exceptionHandler.run(() -> {
            System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
            List<LadderResult> results = Arrays.stream(readLine().split(","))
                    .map(LadderResult::new)
                    .toList();
            return new LadderResults(results, players);
        });
    }

    public Height inputHeight() {
        return exceptionHandler.run(() -> {
            System.out.println("\n최대 사다리 높이는 몇 개인가요?");
            return new Height(Integer.parseInt(readLine()));
        });
    }

    private String readLine() {
        return SCANNER.nextLine().replace(" ", "");
    }
}
