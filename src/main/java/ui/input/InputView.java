package ui.input;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import javax.print.attribute.standard.MediaSize.NA;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_PEOPLES_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_REWARDS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_WANTS_SEE_PERSON = "결과를 보고 싶은 사람은?";
    private static final String NAME_DELIMITER = ",";

    public static List<String> inputPersonName() {
        System.out.println(INPUT_PEOPLES_NAME);
        while (true) {
            try {
                return InputVerifier.validateName(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<String> inputRewards(int peopleNum) {
        System.out.println("\n" + INPUT_REWARDS);
        while (true) {
            try {
                List<String> rewards = Arrays.asList(scanner.nextLine().split(NAME_DELIMITER));
                InputVerifier.validateRewardsNum(rewards, peopleNum);
                return rewards;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int inputLadderHeight() {
        System.out.println("\n" + INPUT_LADDER_HEIGHT);
        while (true) {
            try {
                return InputVerifier.validateLadderHeight(scanner.nextLine());
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println("사다리 높이는 자연수로 입력해 주세요");
            }
        }
    }

    public static String inputNameSeeResultWantsPerson() {
        System.out.println("\n" + "\n" + INPUT_WANTS_SEE_PERSON);
        while (true) {
            try {
                String name = scanner.nextLine().trim();
                InputVerifier.validateViewTargetPerson(name);
                return name;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
