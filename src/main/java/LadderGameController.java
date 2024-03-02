import domain.LadderGame;
import domain.MatchingResult;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.bridgeConstructstrategy.RandomLineConstructStrategy;
import domain.player.Name;
import domain.player.Names;
import domain.result.Prizes;
import java.util.Arrays;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private LadderGameController() {
    }

    private enum Menu {
        RESULT("조회"),
        QUIT("종료");

        private final String input;

        Menu(String input) {
            this.input = input;
        }

        public static Menu from(String input) {
            return Arrays.stream(values())
                    .filter(menu -> menu.input.equals(input))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴 입력입니다."));
        }
    }

    public static void run() {
        LadderGame ladderGame = createLadderGame();
        printLadderGame(ladderGame);
        while (readMenu() != Menu.QUIT) {
            findResult(ladderGame);
        }
    }

    private static LadderGame createLadderGame() {
        try {
            Names names = readNames();
            Prizes prizes = readResults();
            Height height = readHeight();
            return new LadderGame(names, prizes, new Ladder(new RandomLineConstructStrategy(), names, height));
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return createLadderGame();
        }
    }

    private static Names readNames() {
        try {
            Names names = new Names(InputView.readPersonNames());
            OutputView.printNewLine();
            return names;
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return readNames();
        }
    }

    private static Prizes readResults() {
        try {
            Prizes prizes = new Prizes(InputView.readLadderResult());
            OutputView.printNewLine();
            return prizes;
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return readResults();
        }
    }

    private static Height readHeight() {
        try {
            Height height = new Height(InputView.readHeight());
            OutputView.printNewLine();
            return height;
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return readHeight();
        }
    }

    private static void printLadderGame(LadderGame ladderGame) {
        OutputView.printNames(ladderGame.getNames());
        OutputView.printLadder(ladderGame.getLadder());
        OutputView.printResults(ladderGame.getResult());
    }

    private static Menu readMenu() {
        try {
            return Menu.from(InputView.readMenu());
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return readMenu();
        }
    }

    private static void findResult(LadderGame ladderGame) {
        String inputName = InputView.readNameForResult();
        if (nameForAllResult(inputName)) {
            OutputView.printAllResult(ladderGame.findAllResult());
            return;
        }
        try {
            showEachResult(ladderGame, inputName);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            findResult(ladderGame);
        }
    }

    private static boolean nameForAllResult(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력값이 빈 값일 수 없습니다.");
        }
        return "all".equalsIgnoreCase(input);
    }

    private static void showEachResult(LadderGame ladderGame, String input) {
        MatchingResult prize = ladderGame.findEachPrize(new Name(input));
        OutputView.printEachResult(prize);
    }
}
