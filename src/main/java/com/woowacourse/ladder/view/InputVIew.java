package com.woowacourse.ladder.view;

import com.woowacourse.ladder.Height;
import com.woowacourse.ladder.InputValidator;
import com.woowacourse.ladder.PlayerList;
import com.woowacourse.ladder.ResultList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputVIew {

    public static PlayerList promptPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.asList(scanner.nextLine().split(","));

        try {
            return new PlayerList(names);
        } catch (IllegalArgumentException e) {
            return promptPlayerNames();
        }
    }

    public static ResultList promptExecuteResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        List<String> results = Arrays.asList(scanner.nextLine().split(","));

        try {
            return new ResultList(results);
        } catch (IllegalArgumentException e) {
            return promptExecuteResults();
        }
    }

    public static Height promptHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        Scanner scanner = new Scanner(System.in);
        String height = scanner.nextLine();

        try {
            return new Height(height);
        } catch (IllegalArgumentException e) {
            return promptHeight();
        }
    }
}
