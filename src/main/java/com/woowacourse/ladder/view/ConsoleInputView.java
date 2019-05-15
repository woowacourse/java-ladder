package com.woowacourse.ladder.view;

import com.woowacourse.ladder.interfaces.InputView;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInputView implements InputView {

    @Override
    public List<String> promptNames() {
        String promptText = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
        Scanner scanner = new Scanner(System.in);
        System.out.println(promptText);
        List<String> names = Arrays.stream(scanner.nextLine().split(",")).map(String::trim).collect(Collectors.toList());
        while (!InputValidator.isValidNamesInput(names)) {
            System.out.println("잘못된 입력입니다.");
            System.out.println(promptText);
            names = Arrays.asList(scanner.nextLine().split(","));
        }
        return names;
    }

    @Override
    public List<String> promptDestinations() {
        String promptText = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
        Scanner scanner = new Scanner(System.in);
        System.out.println(promptText);
        List<String> results = Arrays.asList(scanner.nextLine().split(","));
        while (!InputValidator.isValidDestinationsInput(results)) {
            System.out.println("잘못된 입력입니다.");
            System.out.println(promptText);
            results = Arrays.asList(scanner.nextLine().split(","));
        }
        return results;
    }

    @Override
    public String promptResultQuery() {
        String promptText = "결과를 보고 싶은 사람은?";
        Scanner scanner = new Scanner(System.in);
        System.out.println(promptText);
        String query = scanner.nextLine();
        // TODO: Error handling is removed, view must provide other error handling methods.
        return query;
    }

    @Override
    public int promptLadderHeight() {
        String promptText = "최대 사다리 높이는  몇개인가요?";
        Scanner scanner = new Scanner(System.in);
        System.out.println(promptText);
        String heightString = scanner.nextLine().trim();
        while(!isValidHeight(heightString)) {
            System.out.println("잘못된 입력입니다");
            System.out.println(promptText);
            heightString = scanner.nextLine();
        }
        return Integer.parseInt(heightString);
    }

    private boolean isValidHeight(String height) {
        if (!isNumber(height)) {
            return false;
        }
        return Integer.parseInt(height) > 0;
    }

    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
