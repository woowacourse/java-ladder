package ladderGame.view;

import ladderGame.domain.Ladder;
import ladderGame.domain.User;
import ladderGame.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static List<User> createUsers() {
        try {
            String names = InputView.inputNames();
            return createUsers(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createUsers();
        }
    }

    private static String inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    private static List<User> createUsers(String inputNames) {
        List<User> users = new ArrayList<>();
        List<String> names = StringUtil.splitComma(inputNames);

        for (int i = 0; i < names.size(); i++) {
            users.add(new User(names.get(i), i));
        }
        return users;
    }

    public static List<String> createResults(int userSize) {
        String inputResults = InputView.inputResults();
        List<String> results = StringUtil.splitComma(inputResults);
        if (results.size() != userSize) {
            System.out.println("결과와 참여자의 수는 같아야합니다");
            return createResults(userSize);
        }
        return results;
    }

    private static String inputResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static Ladder createLadder(int userSize) {
        try {
            int height = InputView.inputLadderHeight();
            return new Ladder(height, userSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createLadder(userSize);
        }
    }

    private static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return inputLadderHeight();
        }
    }

    public static String inputName() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
