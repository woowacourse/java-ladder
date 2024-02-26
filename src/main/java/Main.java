import domain.Game;
import domain.Height;
import domain.Lines;
import domain.Members;
import error.ErrorHandler;
import strategy.PointStrategy;
import strategy.RandomPointStrategy;
import view.InputView;
import view.OutputView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ErrorHandler errorHandler = new ErrorHandler();
        PointStrategy pointStrategy = new RandomPointStrategy();

        start(inputView, outputView, errorHandler, pointStrategy);
    }

    private static void start(
        InputView inputView,
        OutputView outputView,
        ErrorHandler errorHandler,
        PointStrategy pointStrategy) {

        Members members = errorHandler.readUntilNoError(
            Members::from, inputView, "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        Height height = errorHandler.readUntilNoError(
            Height::from, inputView, "최대 사다리 높이는 몇 개인가요?");

        Game game = Game.of(members, Lines.of(members.getCount(), height, pointStrategy));
        outputView.printResult(game);
    }
}
