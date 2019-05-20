package ladder.view;

import ladder.domain.LadderHeight;
import ladder.utils.ValidatorUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)");
        try {
            List<String> names = splitInput(SCANNER.nextLine());
            ValidatorUtils.checkNames(names);
            return new ArrayList<>(names);
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

    public static List<String> inputItems(int numberOfPeople) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        try {
            List<String> items = splitInput(SCANNER.nextLine());
            ValidatorUtils.checkItems(items, numberOfPeople);
            return new ArrayList<>(items);
        } catch (IllegalArgumentException e) {
            return inputItems(numberOfPeople);
        }
    }

    public static String inputParticipant(List<String> names) {
        System.out.println("결과를 보고 싶은 사람은?");
        try {
            String participant = SCANNER.nextLine().trim();
            ValidatorUtils.checkParticipant(names, participant);
            return participant;
        } catch (IllegalArgumentException e) {
            return inputParticipant(names);
        }
    }

    private static List<String> splitInput(String input) {
        return new ArrayList<>(Arrays.asList(input.trim().split(",")));
    }
}
