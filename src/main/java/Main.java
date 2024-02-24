import domain.LadderGame;
import java.util.HashSet;
import java.util.List;
import java.util.function.Supplier;
import view.InputView;
import view.LadderPrinter;
import view.NameInputView;
import view.NamesPrinter;
import view.OutputView;
import view.ResultInputView;
import view.ResultPrinter;

public class Main {
    public static void main(String[] args) {
        LadderGame ladderGame = RetryHelper.retry(() -> {
            OutputView.print("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            List<String> names = NameInputView.getNames(InputView::getInput);
            OutputView.print("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
            List<String> rawResults = ResultInputView.getResults(InputView::getInput, names.size());
            OutputView.print("최대 사다리 높이는 몇 개인가요?");
            int ladderHeight = Integer.parseInt(InputView.getInput());
            return new LadderGame(names, ladderHeight, rawResults);
        });
        List<String> rawNames = ladderGame.getRawNames();
        OutputView.print(NamesPrinter.from(rawNames));
        OutputView.print(LadderPrinter.from(ladderGame.getRawLadder()));
        OutputView.print(NamesPrinter.from(ladderGame.getRawResults()));
        printClimbResult(ladderGame, rawNames);
    }

    private static void printClimbResult(LadderGame ladderGame, List<String> rawNames) {
        String nameThatNeedToShowResult = "";
        while (!nameThatNeedToShowResult.equals("all")) {
            OutputView.print("결과를 보고 싶은 사람은?");
            nameThatNeedToShowResult = NameInputView.getNameThatNeedToShowResult(InputView::getInput,
                    new HashSet<>(ladderGame.getRawNames()));
            OutputView.print("실행 결과");
            List<String> climbResults = ResultPrinter.of(rawNames,
                    ladderGame.showClimbResults(nameThatNeedToShowResult));
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
