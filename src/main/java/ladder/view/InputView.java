package ladder.view;

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
            List<String> names = new ArrayList<>(Arrays.asList(SCANNER.nextLine().trim().split(",")));
            ValidatorUtils.checkNames(names);
            return new ArrayList<>(names);
        } catch (IllegalArgumentException e) {
            return inputNames();
        }
    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            int height = Integer.parseInt(SCANNER.nextLine());
            ValidatorUtils.checkHeight(height);
            return height;
        } catch (IllegalArgumentException e) {
            return inputHeight();
        }
    }

    public static List<String> inputItems() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        try {
            List<String> items = new ArrayList<>(Arrays.asList(SCANNER.nextLine().trim().split(",")));
            ValidatorUtils.checkItems(items);
            return new ArrayList<>(items);
        } catch (IllegalArgumentException e) {
            return inputItems();
        }
    }
}
