import domain.LadderGame;
import domain.LadderGame.LadderGameBuilder;
import domain.RandomLineMakeStrategy;
import dto.LadderGameResults;
import java.util.List;
import util.RetryHelper;
import view.GiftsInputView;
import view.InputView;
import view.LadderHeightInputView;
import view.OutputView;
import view.PlayersInputView;

public class Main {
    public static void main(String[] args) {
        RetryHelper retryHelper = new RetryHelper(10);
        OutputView.print("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> playerNames = retryHelper.retry(() -> PlayersInputView.getPlayerNames(InputView.getInput()));
        OutputView.print("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        List<String> giftNames = retryHelper.retry(() -> GiftsInputView.getGiftNames(InputView.getInput()));
        OutputView.print("최대 사다리 높이는 몇 개인가요?");
        Integer ladderHeight = retryHelper.retry(() -> LadderHeightInputView.getLadderHeight(InputView.getInput()));
        RandomLineMakeStrategy randomLineMakeStrategy = new RandomLineMakeStrategy(playerNames.size());
        LadderGame ladderGame = LadderGameBuilder.builder()
                .players(playerNames.toArray(String[]::new))
                .gifts(giftNames.toArray(String[]::new))
                .ladderHeight(ladderHeight)
                .ladderMakeStrategy(randomLineMakeStrategy::makeLine)
                .build();
        OutputView.printPlayers(playerNames);
        OutputView.printLadder(ladderGame.rawLadder());
        OutputView.printGifts(giftNames);
        LadderGameResults ladderGameResults = retryHelper.retry(() -> {
            String operator = InputView.getInput();
            return ladderGame.start(operator);
        });
        OutputView.printLadderGameResults(ladderGameResults);
    }
}
