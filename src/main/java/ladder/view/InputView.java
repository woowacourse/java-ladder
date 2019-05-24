package ladder.view;

import ladder.domain.DuplicatedNameException;
import ladder.domain.Height;
import ladder.domain.Players;
import ladder.domain.Rewards;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SPACE = " ";
    private static final String EMPTY = "";
    private static final String NAME_SEPERATOR = ",";

    public static Players readPlayers() {
        String inp = SCANNER.nextLine();
        List<String> names = splitNames(inp);
        try {
            return Players.from(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (DuplicatedNameException e) {
            System.out.println(e.getMessage());
        }
        return readPlayers();
    }

    public static Rewards readRewards(int numPlayers) {
        Rewards rewards;
        try {
            rewards = Rewards.of(splitNames(SCANNER.nextLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readRewards(numPlayers);
        }

        if (rewards.size() != numPlayers) {
            System.out.println("플레이어 수와 보상의 수가 다릅니다.");
            return readRewards(numPlayers);
        }
        return rewards;
    }

    private static List<String> splitNames(String inp) {
        inp = inp.replace(SPACE, EMPTY);
        return Arrays.asList(inp.split(NAME_SEPERATOR));
    }

    public static Height readHeight() {
        try {
            return Height.create(Integer.parseInt(SCANNER.nextLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readHeight();
        }
    }
}
