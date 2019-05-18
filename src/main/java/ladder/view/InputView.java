package ladder.view;

import ladder.utils.ValidatorUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        try {
            List<String> names = Arrays.asList(SCANNER.nextLine().trim().split(","));
            ValidatorUtils.checkNames(names);
            return names;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputNames();
        }
    }

    public static List<String> inputItems(int numberOfPeople) {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        try {
            List<String> items = Arrays.asList(SCANNER.nextLine().trim().split(","));
            ValidatorUtils.checkItems(items, numberOfPeople);
            return items;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputItems(numberOfPeople);
        }
    }

    public static int inputHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        try {
            int height = Integer.parseInt(SCANNER.nextLine());
            ValidatorUtils.checkHeight(height);
            return height;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputHeight();
        }
    }

    public static String inputParticipant(List<String> names) {
        System.out.println("\n결과를 보고 싶은 사람은?");
        try {
            String participant = SCANNER.nextLine().trim();
            ValidatorUtils.checkParticipant(participant, names);
            return participant;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputParticipant(names);
        }
    }
}
