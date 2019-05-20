package ladder.view;

import ladder.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String ALL_PLAYERS = "all";

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

    public static List<Player> readPlayerOrAll(List<Player> players) {
        System.out.println("결과를 보고 싶은 사람은?");
        String input = scanner.nextLine();
        if (input.equals(ALL_PLAYERS)) {
            return new ArrayList<>(players);
        }

        List<Player> readPlayers = players.stream().filter(player -> player.getName().equals(input)).collect(Collectors.toList());
        if (!readPlayers.isEmpty()) {
            return readPlayers;
        }

        System.out.println("존재하지 않는 이름입니다.");
        return readPlayerOrAll(players);
    }
}
