package ladder.view;

import ladder.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Player> initPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        List<Player> players;
        try {
            players = PlayerFactory.createAll(Arrays.asList(input.split(",")));
        } catch (DuplicatedNameException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initPlayers();
        }
        return players;
    }

    public static List<Reward> initRewards(List<Player> players) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        List<Reward> rewards;
        try {
            rewards = RewardFactory.createAll(Arrays.asList(input.split(",")), players);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initRewards(players);
        }
        return rewards;
    }

    public static int initLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = 0;
        try {
            height = Integer.parseUnsignedInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            initLadderHeight();
        }
        return height;
    }


    public static void readPlayer() {
        
    }
}
