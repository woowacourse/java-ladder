import domain.LadderGame;
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
            LadderGame ladderGame = RetryHelper.retry(() -> {
                return createLadderGame(bufferedReader, outputView);
            });
            outputView.printLadderResult(ladderGame.getNames(), ladderGame.getLadder());
        }
    }

    private static LadderGame createLadderGame(BufferedReader bufferedReader, OutPutView outputView) {
        var inputView = new InputView(bufferedReader);

        outputView.printNamesInput();
        String nameInput = inputView.getInput();

        outputView.printHeightInput();
        int ladderHeight = Integer.parseInt(inputView.getInput());
        
        return new LadderGame(nameInput, ladderHeight);
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
