import domain.LadderGame;
import java.util.List;
import java.util.function.Supplier;
import view.ClimbResultPrinter;
import view.InputView;
import view.LadderGameOperatorInputView;
import view.LadderPrinter;
import view.NameInputView;
import view.NamesPrinter;
import view.OutputView;
import view.ResultInputView;

public class Main {
    public static void main(String[] args) {
        LadderGame ladderGame = generateLadderGame();

        printName(ladderGame);
        printLadder(ladderGame);
        printResults(ladderGame);

        List<String> rawNames = ladderGame.getRawNames();
        printClimbResult(ladderGame, rawNames);
    }

    private static LadderGame generateLadderGame() {
        return RetryHelper.retry(() -> {
            OutputView.print("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            List<String> names = NameInputView.getNames(InputView::getInput);
            OutputView.print("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
            List<String> rawResults = ResultInputView.getResults(InputView::getInput, names.size());
            OutputView.print("최대 사다리 높이는 몇 개인가요?");
            int ladderHeight = Integer.parseInt(InputView.getInput());
            return new LadderGame(names, ladderHeight, rawResults);
        });
    }

    private static void printName(LadderGame ladderGame) {
        OutputView.print(NamesPrinter.from(ladderGame.getRawNames()));
    }

    private static void printLadder(LadderGame ladderGame) {
        OutputView.print(LadderPrinter.from(ladderGame.getRawLadder()));
    }

    private static void printResults(LadderGame ladderGame) {
        OutputView.print(NamesPrinter.from(ladderGame.getRawResults()));
    }

    private static void printClimbResult(LadderGame ladderGame, List<String> rawNames) {
        String gameOperator = "";
        while (!gameOperator.equals("all")) {
            OutputView.print("결과를 보고 싶은 사람은?");
            gameOperator = RetryHelper.retry(
                    () -> LadderGameOperatorInputView.getOperator(InputView::getInput, ladderGame.getRawNames()));
            OutputView.print("실행 결과");
            List<String> climbResults = ClimbResultPrinter.of(rawNames, ladderGame.getClimbResults(gameOperator));
            climbResults.forEach(OutputView::print);
        }
    }

    static final class RetryHelper {

        public static <E> E retry(Supplier<E> supplier) {
            E result = null;
            while (result == null) {
                result = useSupplier(supplier);
            }
            return result;
        }

        private static <E> E useSupplier(Supplier<E> supplier) {
            try {
                return supplier.get();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
    }
}
