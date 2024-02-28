import domain.BridgesRandomGenerator;
import domain.LadderGame;
import domain.LadderGameResult;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class Main {
    public static void main(String[] args) throws IOException {
        var outputView = new OutputView();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            var inputView = new InputView(bufferedReader);
            LadderGame ladderGame = RetryHelper.retryWithReturn(() -> createLadderGame(outputView, inputView));
            LadderGameResult ladderGameResult = ladderGame.calculateLadderGameResult();
            outputView.printLadderResult(ladderGame);
            RetryHelper.retryWithoutReturn(
                    () -> searchLadderResultFromName(outputView, inputView, ladderGameResult));
        }
    }

    private static void searchLadderResultFromName(OutputView outputView, InputView inputView,
                                                   LadderGameResult ladderGameResult) {

        outputView.printSearchNameInput();
        String searchName = inputView.getInput();
        while (!searchName.equals("all")) {
            outputView.printSearchNameLadderResult(searchName, ladderGameResult);
            outputView.printSearchNameInput();
            searchName = inputView.getInput();
        }
        outputView.printAllNameLadderResult(ladderGameResult);
    }

    private static LadderGame createLadderGame(OutputView outputView, InputView inputView) {

        outputView.printNamesInput();
        String nameInput = inputView.getInput();

        outputView.printLadderResultInput();
        String rawLadderResult = inputView.getInput();

        outputView.printHeightInput();
        int ladderHeight = Integer.parseInt(inputView.getInput());

        return new LadderGame(nameInput, rawLadderResult, ladderHeight, new BridgesRandomGenerator());
    }

    static final class RetryHelper {

        public static <E> E retryWithReturn(Supplier<E> supplier) {
            E result = null;
            while (result == null) {
                result = useSupplier(supplier);
            }
            return result;
        }

        public static void retryWithoutReturn(Runnable runnable) {
            boolean isContinue = true;
            while (isContinue) {
                isContinue = useRunnable(runnable);
            }
        }

        private static <E> E useSupplier(Supplier<E> supplier) {
            try {
                return supplier.get();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }

        private static boolean useRunnable(Runnable runnable) {
            try {
                runnable.run();
                return false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return true;
            }
        }
    }
}
