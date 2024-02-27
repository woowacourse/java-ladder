import domain.Game;
import domain.Height;
import domain.Members;
import domain.Rewards;
import error.ErrorHandler;
import strategy.PointStrategy;
import strategy.RandomPointStrategy;
import view.InputView;
import view.OutputView;

public class Main {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final ErrorHandler errorHandler = new ErrorHandler();
    private static final PointStrategy pointStrategy = new RandomPointStrategy();

    public static void main(String[] args) {
        Members members = errorHandler.readUntilNoError(Main::makeMembers);
        Height height = errorHandler.readUntilNoError(Main::makeHeight);
        Rewards rewards = errorHandler.readUntilNoError(() -> makeRewards(members));

        Game game = Game.of(members, height, rewards, pointStrategy);
        outputView.printGame(game);


    }

    private static Members makeMembers() {
        return Members.from(inputView.readMembers());
    }

    private static Height makeHeight() {
        return Height.from(inputView.readHeight());
    }

    private static Rewards makeRewards(Members members) {
        return Rewards.from(members.getCount(), inputView.readRewards());
    }
}
