import domain.Game;
import domain.Height;
import domain.Members;
import domain.Rewards;
import error.ErrorHandler;
import java.util.Map;
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
        processGameResult(game.findRewardMap());
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

    // TODO: 구조가 너무 복잡함. 구조를 간소화하는 작업 필요
    private static void processGameResult(Map<String, String> rewardMap) {
        boolean isEnd = false;
        while (!isEnd) {
            String memberName = errorHandler.readUntilNoError(() -> makeMemberName(rewardMap));
            isEnd = printResult(memberName, rewardMap);
        }
    }

    private static boolean printResult(String memberName, Map<String, String> rewardMap) {
        if (memberName.equals("all")) {
            outputView.printAllResult(rewardMap);
            return true;
        }
        outputView.printOneResult(memberName, rewardMap);
        return false;
    }

    private static String makeMemberName(Map<String, String> rewardMap) {
        String memberName = inputView.readMemberName();
        if (memberName.equals("all")) {
            return memberName;
        }
        if (!rewardMap.containsKey(memberName)) {
            throw new IllegalArgumentException("존재하지 않는 플레이어입니다.");
        }
        return memberName;
    }
}
