import domain.GameResult;
import domain.LadderGame;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.bridgeConstructstrategy.RandomBridgeConstructStrategy;
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
        GameResult gameResult = ladderGame.createGameResult();
        while (true) {
            Menu menu = readMenu();
            if (menu == Menu.QUIT) {
                break;
            }
            showResult(gameResult);
        }
    }

    private static LadderGame createLadderGame() {
        try {
            Names names = readNames();
            Prizes prizes = readResults();
            Height height = readHeight();
            return new LadderGame(names, prizes, new Ladder(new RandomBridgeConstructStrategy(), names, height));
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

    private static void showResult(GameResult gameResult) {
        String input = InputView.readNameForResult();
        if ("all".equals(input)) {
            OutputView.printAllResult(gameResult.getAllResult());
            return;
        }
        Name inputName = new Name(input);
        OutputView.printEachResult(inputName, gameResult.getResult(inputName));
    }
}
