import domain.LadderGame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Supplier;
import view.InputView;
import view.OutPutView;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            LadderGame ladderGame = RetryHelper.retry(() -> {
                var inputView = new InputView(bufferedReader);
                OutPutView.print("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
                String nameInput = inputView.getInput();
                OutPutView.print("최대 사다리 높이는 몇 개인가요?");
                int ladderHeight = Integer.parseInt(inputView.getInput());
                return new LadderGame(nameInput, ladderHeight);
            });
            OutPutView.print(ladderGame.getNamesString());
            OutPutView.print(ladderGame.getLadderString());
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
