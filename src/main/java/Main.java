import domain.LadderGame;
import domain.LadderGameResult;
import domain.Names;
import domain.RowRandomGenerator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Supplier;
import view.InputView;
import view.OutPutView;

public class Main {
    public static void main(String[] args) throws IOException {
        var outputView = new OutPutView();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            var inputView = new InputView(bufferedReader);
            LadderGame ladderGame = RetryHelper.retryWithReturn(() -> createLadderGame(outputView, inputView));
            outputView.printLadderResult(ladderGame);
            LadderGameResult ladderGameResult = ladderGame.calculateLadderGameResult();
            RetryHelper.retryWithoutReturn(
                    () -> searchLadderResultFromName(outputView, inputView, ladderGame.getNames(), ladderGameResult));
        }
    }

    private static void searchLadderResultFromName(OutPutView outputView, InputView inputView,
                                                   Names names, LadderGameResult ladderGameResult) {
        String searchName = "";
        while (!searchName.equals("all")) {
            outputView.printSearchNameInput();
            searchName = inputView.getInput();
            outputView.printSearchNameLadderResult(searchName, ladderGameResult);
        }
        outputView.printAllNameLadderResult(names, ladderGameResult);
    }

    private static LadderGame createLadderGame(OutPutView outputView, InputView inputView) {

        outputView.printNamesInput();
        String nameInput = inputView.getInput();

        outputView.printLadderResultInput();
        String rawLadderResult = inputView.getInput();

        outputView.printHeightInput();
        int ladderHeight = Integer.parseInt(inputView.getInput());

        return new LadderGame(nameInput, rawLadderResult, ladderHeight, new RowRandomGenerator());
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
