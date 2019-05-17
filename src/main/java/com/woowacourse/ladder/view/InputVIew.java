package com.woowacourse.ladder.view;

import com.woowacourse.ladder.domain.Height;
import com.woowacourse.ladder.domain.PlayerList;
import com.woowacourse.ladder.domain.ResultItems;
import com.woowacourse.ladder.domain.ResultQuery;

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
            System.out.println("올바른 사람 이름을 입력하세요.(all이란 이름은 금지입니다.)");
            return promptPlayerNames();
        }
    }

    public static ResultItems promptExecuteResults(PlayerList playerList) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        List<String> results = Arrays.asList(scanner.nextLine().split(","));

        try {
            return new ResultItems(results,playerList);
        } catch (IllegalArgumentException e) {
            System.out.println("올바른 실행결과를 입력해주세요.");
            return promptExecuteResults(playerList);
        }
    }

    public static Height promptHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        Scanner scanner = new Scanner(System.in);
        String height = scanner.nextLine();

        try {
            return new Height(height);
        } catch (IllegalArgumentException e) {
            System.out.println("올바른 사다리 높이를 입력해주세요.");
            return promptHeight();
        }
    }

    public static ResultQuery promptResultQuery(PlayerList playerList) {
        System.out.println("결과를 보고 싶은 사람은?");
        Scanner scanner = new Scanner(System.in);
        String resultQuery = scanner.nextLine();

        try {
            return new ResultQuery(resultQuery,playerList);
        }catch (IllegalArgumentException e){
            System.out.println("결과를 보고 싶은 사람을 올바르게 입력해주세요.");
            return promptResultQuery(playerList);
        }
    }
}
