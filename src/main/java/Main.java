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
            LadderGame ladderGame = RetryHelper.retry(() -> createLadderGame(outputView, inputView));
            outputView.printLadderResult(ladderGame.getNames(), ladderGame.getLadder(), ladderGame.getLadderResults());
            RetryHelper.retry(
                    () -> searchLadderResultFromName(outputView, inputView, ladderGame.getNames(),
                            ladderGame.calculateLadderGameResult()));
        }
    }

    private static boolean searchLadderResultFromName(OutPutView outputView, InputView inputView,
                                                      Names names, LadderGameResult ladderGameResult) {
        while (true) {
            outputView.printSearchNameInput();
            String searchName = inputView.getInput();
            if (searchName.equals("all")) {
                outputView.printAllNameLadderResult(names, ladderGameResult);
                break;
            }
            outputView.printSearchNameLadderResult(searchName, ladderGameResult);
        }
        return true;
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
