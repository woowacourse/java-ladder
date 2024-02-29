import domain.Game;
import domain.Height;
import domain.Members;
import domain.Rewards;
import error.ErrorHandler;
import java.util.Map;
import strategy.ConnectStrategy;
import strategy.RandomConnectStrategy;
import view.InputView;
import view.OutputView;

public class Main {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final ErrorHandler errorHandler = new ErrorHandler();
    private static final ConnectStrategy CONNECT_STRATEGY = new RandomConnectStrategy();
    private static final String COMMAND_PRINT_ALL = "all";

    public static void main(String[] args) {
        Members members = errorHandler.readUntilNoError(Main::makeMembers);
        Height height = errorHandler.readUntilNoError(Main::makeHeight);
        Rewards rewards = errorHandler.readUntilNoError(() -> makeRewards(members));
        Game game = Game.of(members, height, rewards, CONNECT_STRATEGY);

        outputView.printGame(game);
        readAndPrintGameResult(game.findRewardMap());
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

    private static void readAndPrintGameResult(Map<String, String> rewardMap) {
        String name;
        while (!(name = errorHandler.readUntilNoError(() -> makeMemberName(rewardMap))).equals(COMMAND_PRINT_ALL)) {
            outputView.printRewardName(rewardMap.get(name));
        }
        outputView.printAllResult(rewardMap);
    }

    private static String makeMemberName(Map<String, String> rewardMap) {
        String memberName = inputView.readMemberName();
        if (memberName.equals(COMMAND_PRINT_ALL)) {
            return memberName;
        }
        if (!rewardMap.containsKey(memberName)) {
            throw new IllegalArgumentException("존재하지 않는 플레이어입니다.");
        }
        return memberName;
    }
}
