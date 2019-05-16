package ladder.view;

import ladder.model.Person;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static String WRONG_INPUT_MESSAGE = "잘못된 입력입니다. 다시 입력해주세요.";
    private static Scanner input = new Scanner(System.in);

    public static List<Person> inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        try {
            return filterInputs(input.nextLine()).stream().map(name -> new Person(name)).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(WRONG_INPUT_MESSAGE);
            return inputNames();
        }
    }

    public static List<String> inputRewards() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        try {
            return filterInputs(input.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(WRONG_INPUT_MESSAGE);
            return inputRewards();
        }
    }

    public static int inputHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        try {
            final int height = Integer.parseInt(input.nextLine().trim());
            if (height < 1) {
                throw new IllegalArgumentException();
            }
            return height;
        } catch (IllegalArgumentException e) {
            System.out.println(WRONG_INPUT_MESSAGE);
            return inputHeight();
        }
    }

    public static List<String> inputCandidates() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        return filterInputs(input.nextLine());
    }

    private static List<String> filterInputs(String input) {
        List<String> tokens = Stream.of(input.split(",")).map(x -> x.trim()).filter(x -> !x.equals("") && !x.equals(" ")).collect(Collectors.toList());
        if (tokens.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return tokens;
    }
}