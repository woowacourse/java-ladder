package ladder.view;

import ladder.domain.Items;
import ladder.domain.LadderHeight;
import ladder.domain.Player;
import ladder.domain.Players;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static Players inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)");
        try {
            List<Player> players = new ArrayList<>();
            List<String> names = splitInput(SCANNER.nextLine());

            names.forEach(name -> players.add(new Player(name)));
            return new Players(players);
        } catch (IllegalArgumentException e) {
            return inputNames();
        }
    }

    public static LadderHeight inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            int height = Integer.parseInt(SCANNER.nextLine());
            return new LadderHeight(height);
        } catch (IllegalArgumentException e) {
            return inputHeight();
        }
    }

    public static Items inputItems(int numberOfPeople) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        try {
            List<String> itemNames = splitInput(SCANNER.nextLine());

            return new Items(itemNames, numberOfPeople);
        } catch (IllegalArgumentException e) {
            return inputItems(numberOfPeople);
        }
    }

    public static String inputParticipant(Players players) {
        System.out.println("결과를 보고 싶은 사람은?");
        try {
            String participant = SCANNER.nextLine().trim();
            players.checkParticipant(participant);
            return participant;
        } catch (IllegalArgumentException e) {
            return inputParticipant(players);
        }
    }

    private static List<String> splitInput(String input) {
        return new ArrayList<>(Arrays.asList(input.trim().split(",")));
    }
}
