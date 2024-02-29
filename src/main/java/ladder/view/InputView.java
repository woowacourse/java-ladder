package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import ladder.domain.Height;
import ladder.domain.LadderResult;
import ladder.domain.LadderResults;
import ladder.domain.Player;
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
            List<Player> names = Arrays.stream(readAndSplitByComma())
                    .map(name -> {
                        if (name.equals("all")) {
                            throw new IllegalArgumentException("플레이어 이름으로 all은 입력할 수 없습니다");
                        }
                        return new Player(name);
                    })
                    .toList();
            return new Players(names);
        });
    }

    public LadderResults inputLadderResults(Players players) {
        return exceptionHandler.run(() -> {
            System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
            List<LadderResult> results = Arrays.stream(readAndSplitByComma())
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

    public Player inputPlayerFrom(Players players) {
        return exceptionHandler.run(() -> {
            System.out.println("\n결과를 보고 싶은 사람은?");
            Player player = new Player(readLine());
            if (!players.exists(player) && !new Player("all").equals(player)) {
                throw new IllegalArgumentException("존재하지 않는 이름입니다: %s".formatted(player.name()));
            }
            return player;
        });
    }

    private String readLine() {
        return SCANNER.nextLine();
    }

    private String[] readAndSplitByComma() {
        return readLine().split(",");
    }
}
