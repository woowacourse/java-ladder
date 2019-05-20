package ladder.view;

import ladder.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static Players getPlayers() {
        try {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)");
            String userInput = SCANNER.nextLine();
            String[] commaSeparatedUserInput = userInput.split(",");
            return inputToPlayers(Arrays.asList(commaSeparatedUserInput));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getPlayers();
        }
    }

    private static Players inputToPlayers(List<String> inputNames) {
        Players.NUM_OF_PLAYERS = inputNames.size();
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < inputNames.size(); i++) {
            players.add(new Player(new PlayerName(inputNames.get(i)), new Position(i))); // exception can be thrown
        }
        return new Players(players);
    }

    public static Rewards getRewards() {
        try {
            System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
            String userInput = SCANNER.nextLine();
            String[] commaSeparatedUserInput = userInput.split(",");
            return inputToRewards(Arrays.asList(commaSeparatedUserInput));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getRewards();
        }
    }

    private static Rewards inputToRewards(List<String> inputRewards) {
        List<Reward> rewards = new ArrayList<>();
        for (String reward : inputRewards) {
            rewards.add(new Reward(reward));
        }
        return new Rewards(rewards);
    }

    public static LadderHeight getLadderHeight() {
        try {
            System.out.println("\n최대 사다리 높이는 몇 개인가요?");
            String userInput = SCANNER.nextLine();
            return inputToLadderHeight(userInput);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getLadderHeight();
        }
    }

    private static LadderHeight inputToLadderHeight(String inputInteger) {
        try {
            Integer.parseInt(inputInteger);
        } catch (Exception e) {
            throw new IllegalArgumentException("올바른 정수 입력이 아닙니다.");
        }
        return new LadderHeight(Integer.parseInt(inputInteger));
    }

    public static PlayerName getPlayerName(Players players) {
        try {
            System.out.println("\n결과를 보고 싶은 사람은?");
            String userInput = SCANNER.nextLine();
            return inputToPlayerName(userInput, players.getPlayerNames());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getPlayerName(players);
        }
    }

    private static PlayerName inputToPlayerName(String inputName, List<PlayerName> playerNames) {
        if (inputName.equals("all")) {
            return new PlayerName("all");
        }

        if (playerNames.contains(new PlayerName(inputName))) {
            return new PlayerName(inputName);
        }

        throw new IllegalArgumentException("존재하지 않는 플레이어 이름입니다.");
    }
}
