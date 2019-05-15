package com.woowacourse.ladder.view;

import com.woowacourse.ladder.interfaces.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleInputView implements InputView {

    @Override
    public List<String> promptNames() {
        String promptText = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
        System.out.println(promptText);
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.asList(scanner.nextLine().split(","));
        while (!InputValidator.isValidNamesInput(names)) {
            System.out.println("잘못된 입력입니다.");
            System.out.println(promptText);
            names = Arrays.asList(scanner.nextLine().split(","));
        }

        return names;
    }

    @Override
    public List<String> promptExpectedResult() {
        String promptText = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
        Scanner scanner = new Scanner(System.in);
        List<String> results = Arrays.asList(scanner.nextLine().split(","));

        while (!InputValidator.isValidExpectedResults(results)) {
            System.out.println("잘못된 입력입니다.");
            System.out.println(promptText);
            results = Arrays.asList(scanner.nextLine().split(","));
        }

        return results;
    }

    @Override
    public List<String> promptNameToQuery() {
        String promptText = "결과를 보고 싶은 사람은?";
        Scanner scanner = new Scanner(System.in);
        System.out.println(promptText);
        List<String> queryTokens = Arrays.asList(scanner.nextLine().split(","));

        while(!InputValidator.isValidResultQuery(queryTokens)) {
            System.out.println("잘못된 입력입니다.");
            System.out.println(promptText);
            queryTokens = Arrays.asList(scanner.nextLine().split(","));
        }

        return queryTokens;
    }

    @Override
    public int promptLadderHeight() {
        String promptText = "최대 사다리 높이는  몇개인가요?";
        Scanner scanner = new Scanner(System.in);
        System.out.println(promptText);
        int height = scanner.nextInt();

        while(!isValidHeight(height)) {
            System.out.println("잘못된 입력입니다");
            System.out.println(promptText);
            height = scanner.nextInt();
        }

        return height;
    }

    private boolean isValidHeight(int height) {
        return height > 0;
    }
}
