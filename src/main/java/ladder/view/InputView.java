package ladder.view;

import ladder.domain.Items;
import ladder.domain.Player;
import ladder.domain.Players;

import java.util.Scanner;

public class InputView {
    private static final int MIN_LENGTH_OF_HEIGHT = 1;
    private static final Scanner SCANNER = new Scanner(System.in);

    public static Players inputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        try {
            Players players = new Players(SCANNER.nextLine().trim().split(","));
            return players;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputPlayers();
        }
    }

    public static Items inputItems(Players players) {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        try {
            Items items = new Items(SCANNER.nextLine().trim().split(","), players);
            return items;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputItems(players);
        }
    }

    public static int inputHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        try {
            int height = Integer.parseInt(SCANNER.nextLine());
            checkHeight(height);
            return height;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputHeight();
        }
    }

    private static void checkHeight(int height) {
        if (height < MIN_LENGTH_OF_HEIGHT) {
            throw new IllegalArgumentException("높이는 자연수여야 합니다.");
        }
    }

    public static Player inputParticipant(Players players) {
        System.out.println("\n결과를 보고 싶은 사람은?");
        try {
            Player participant = new Player(SCANNER.nextLine().trim());
            checkParticipant(participant, players);
            return participant;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputParticipant(players);
        }
    }

    private static void checkParticipant(Player participant, Players players) {
        if (!players.contains(participant) && !isAll(participant)) {
            throw new IllegalArgumentException("게임에 참여하지 않은 이름입니다.");
        }
    }

    private static boolean isAll(Player player) {
        return player.toString().equals("all");
    }
}
