package ladder.view;

import ladder.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SPACE = " ";
    private static final String EMPTY = "";
    private static final String NAME_SEPERATOR = ",";


    public static Players readPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        try {
            return Players.from(splitNames(SCANNER.nextLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (DuplicatedNameException e) {
            System.out.println(e.getMessage());
        }
        return readPlayers();
    }

    public static Rewards readRewards(int numPlayers) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        try {
            return createRewards(splitNames(SCANNER.nextLine()), numPlayers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readRewards(numPlayers);
        }
    }

    private static Rewards createRewards(List<String> splitNames, int numPlayers) {
        if (splitNames.size() != numPlayers) {
            throw new IllegalArgumentException("플레이어 수와 보상의 수가 다릅니다.");
        }
        return Rewards.from(splitNames);
    }

    private static List<String> splitNames(String inp) {
        inp = inp.replace(SPACE, EMPTY);
        System.out.println(inp);
        return Arrays.asList(inp.split(NAME_SEPERATOR));
    }

    public static Height readHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            return Height.create(Integer.parseInt(SCANNER.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("높이는 숫자여야 합니다");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return readHeight();
    }

    public static Player readExistPlayer(Players players) {
        System.out.println("결과를 보고 싶은 사람은? (모두 확인하려면 'all'을 입력하세요)");
        try {
            return createExistPlayer(players);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readExistPlayer(players);
        }
    }

    private static Player createExistPlayer(Players players) {
        Player player = Player.from(SCANNER.nextLine());
        if (!player.equals(Player.ALL) && !players.contains(player)) {
            throw new IllegalArgumentException("존재하지 않는 플레이어 입니다. 다시입력해주세요.");
        }
        return player;
    }
}
