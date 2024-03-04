package ladder.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import ladder.domain.ladder.Height;
import ladder.domain.player.Location;
import ladder.domain.player.Name;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.result.Result;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String QUIT_RESULT_COMMAND = "quit";
    public static final String ALL_RESULT_COMMAND = "all";

    public static Players inputNames() {
        System.out.println("\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> names = Arrays.asList(readLine().split(","));
        List<Player> players = new ArrayList<>();
        IntStream.range(0, names.size())
                .forEach(index -> players.add(new Player(new Name(names.get(index)), new Location(index))));
        return new Players(players);
    }

    public static List<Result> inputResults() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        List<String> resultValues = Arrays.asList(readLine().split(","));
        List<Result> results = new ArrayList<>();
        resultValues.forEach(resultValue -> results.add(new Result(resultValue)));
        return results;
    }

    public static Height inputHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return new Height(readInt());
    }

    public static String inputNameForResult() {
        System.out.printf("\n결과를 보고 싶은 사람은? (%s 입력시 종료)%n", QUIT_RESULT_COMMAND);
        return readLine();
    }

    private static String readLine() {
        return SCANNER.nextLine().replace(" ", "");
    }

    private static int readInt() {
        String input = readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("입력이 정수가 아닙니다: " + input);
        }
    }
}
