import domain.Game;
import domain.Height;
import domain.Members;
import domain.Rewards;
import error.ErrorHandler;
import java.util.List;
import java.util.Map;
import strategy.ConnectStrategy;
import strategy.RandomConnectStrategy;
import view.InputView;
import view.OutputView;
import view.StringParser;

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
        List<String> names = StringParser.parseToStringList(inputView.readMembers());
        return Members.from(names);
    }

    private static Height makeHeight() {
        int height = StringParser.parseToInt(inputView.readHeight());
        return Height.from(height);
    }

    private static Rewards makeRewards(Members members) {
        List<String> names = StringParser.parseToStringList(inputView.readRewards());
        return Rewards.from(members.getCount(), names);
    }

    private static void readAndPrintGameResult(Map<String, String> rewardMap) {
        String name = errorHandler.readUntilNoError(() -> makeMemberName(rewardMap));
        if (name.equals(COMMAND_PRINT_ALL)) {
            outputView.printAllResult(rewardMap);
            return;
        }
        outputView.printRewardName(rewardMap.get(name));
        readAndPrintGameResult(rewardMap);
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
