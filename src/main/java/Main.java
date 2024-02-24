import domain.LadderGame;
import java.util.List;
import java.util.function.Supplier;
import view.InputView;
import view.LadderPrinter;
import view.NameInputView;
import view.NamesPrinter;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        LadderGame ladderGame = RetryHelper.retry(() -> {
            OutputView.print("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            List<String> names = NameInputView.getNames(InputView::getInput);
            OutputView.print("최대 사다리 높이는 몇 개인가요?");
            int ladderHeight = Integer.parseInt(InputView.getInput());
            return new LadderGame(names, ladderHeight);
        });
        OutputView.print(NamesPrinter.from(ladderGame.getRawNames()));
        OutputView.print(LadderPrinter.from(ladderGame.getRawLadder()));
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
