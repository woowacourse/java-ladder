import domain.BridgesRandomGenerator;
import domain.LadderGame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class Main {
    private static final String SEARCH_ALL = "all";

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            var inputView = new InputView(bufferedReader);
            LadderGame ladderGame = RetryHelper.retryWithReturn(() -> createLadderGame(inputView));
            var outputView = new OutputView(ladderGame);
            outputView.printLadderResult();
            RetryHelper.retryWithoutReturn(() -> searchLadderResultFromName(inputView, outputView));
        }
    }

    private static LadderGame createLadderGame(InputView inputView) {
        String nameInput = inputView.getNamesInputFromConsole();
        String rawLadderResult = inputView.getLadderResultsFromConsole();
        int ladderHeight = inputView.getHeightInputFromConsole();
        return new LadderGame(nameInput, rawLadderResult, ladderHeight, new BridgesRandomGenerator());
    }

    private static void searchLadderResultFromName(InputView inputView, OutputView outputView) {
        String searchName = inputView.getSearchNameFromConsole();
        while (!searchName.equals(SEARCH_ALL)) {
            outputView.printSearchNameLadderResult(searchName);
            searchName = inputView.getSearchNameFromConsole();
        }
        outputView.printAllNameLadderResult();
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
