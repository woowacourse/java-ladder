import domain.LadderGame;
import domain.LadderGame.LadderGameBuilder;
import domain.LineGenerateStrategy;
import domain.RandomLineGenerateStrategy;
import dto.LadderGameResults;
import java.util.List;
import util.RetryHelper;
import view.GiftsInputView;
import view.InputView;
import view.LadderGameOperatorInputView;
import view.LadderHeightInputView;
import view.OutputView;
import view.PlayersInputView;

public class Main {
    public static void main(String[] args) {
        RetryHelper retryHelper = new RetryHelper(10);
        List<String> playerNames = getPlayerNames(retryHelper);
        List<String> giftNames = getGiftNames(retryHelper, playerNames);
        Integer ladderHeight = getLadderHeight(retryHelper);

        LadderGame ladderGame = makeLadderGame(playerNames, giftNames, ladderHeight);
        printLadderGame(playerNames, giftNames, ladderGame);

        printLadderGameResults(playerNames, ladderGame);
    }

    private static List<String> getPlayerNames(RetryHelper retryHelper) {
        return retryHelper.retry(() -> {
            OutputView.print("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            return PlayersInputView.getPlayerNames(InputView.getInput());
        });
    }

    private static List<String> getGiftNames(RetryHelper retryHelper, List<String> playerNames) {
        return retryHelper.retry(() -> {
            OutputView.print("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
            return GiftsInputView.getGiftNames(InputView.getInput(), playerNames.size());
        });
    }

    private static Integer getLadderHeight(RetryHelper retryHelper) {
        return retryHelper.retry(() -> {
            OutputView.print("최대 사다리 높이는 몇 개인가요?");
            return LadderHeightInputView.getLadderHeight(InputView.getInput());
        });
    }

    private static LadderGame makeLadderGame(List<String> playerNames, List<String> giftNames, Integer ladderHeight) {
        LineGenerateStrategy lineGenerateStrategy = new RandomLineGenerateStrategy();
        return makeLadderGame(playerNames, giftNames, ladderHeight, lineGenerateStrategy);
    }

    private static LadderGame makeLadderGame(List<String> playerNames, List<String> giftNames, Integer ladderHeight,
                                             LineGenerateStrategy randomLineMakeStrategy) {
        return LadderGameBuilder.builder()
                .players(playerNames)
                .gifts(giftNames)
                .ladderHeight(ladderHeight)
                .lineGenerateStrategy(randomLineMakeStrategy)
                .build();
    }

    private static void printLadderGame(List<String> playerNames, List<String> giftNames, LadderGame ladderGame) {
        OutputView.printPlayers(playerNames);
        OutputView.printLadder(ladderGame.rawLadder());
        OutputView.printGifts(giftNames);
    }

    private static void printLadderGameResults(List<String> playerNames, LadderGame ladderGame) {
        String ladderGameResultOwner = showLadderGameResult(playerNames, ladderGame);
        while (!ladderGameResultOwner.equals("all")) {
            ladderGameResultOwner = showLadderGameResult(playerNames, ladderGame);
        }
    }

    private static String showLadderGameResult(List<String> playerNames, LadderGame ladderGame) {
        RetryHelper retryHelper = new RetryHelper(10);
        return retryHelper.retry(() -> {
            String operator = LadderGameOperatorInputView.getOperator(InputView.getInput(), playerNames);
            LadderGameResults ladderGameResults = ladderGame.start(operator);
            OutputView.printLadderGameResults(ladderGameResults);
            return operator;
        });
    }
}
