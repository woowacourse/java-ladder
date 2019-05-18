package laddergame.util;

import laddergame.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public static void outputMessage(String message) {
        System.out.println(message);
    }

    public static void outputLadderGame(LadderGame ladderGame) {
        List<String> playerNames = ladderGame.getPlayers()
                .stream()
                .map(Player::getName)
                .collect(Collectors.toList());
        List<String> rewardNames = ladderGame.getRewards()
                .stream()
                .map(Reward::getName)
                .collect(Collectors.toList());

        System.out.println("사다리 결과");
        outputNames(playerNames);
        outputLadder(ladderGame.getLadder());
        outputNames(rewardNames);
    }

    private static void outputNames(List<String> names) {
        StringBuilder namesView = new StringBuilder();
        for (String name : names) {
            namesView.append(makeNameView(name));
        }
        System.out.println(namesView);
    }

    private static StringBuilder makeNameView(String name) {
        StringBuilder nameView = new StringBuilder("       ");
        int nameStart = 3 - name.length() / 2;
        int nameEnd = nameStart + name.length();

        nameView.replace(nameStart, nameEnd, name);
        return nameView;
    }

    private static void outputLadder(Ladder ladder) {
        StringBuilder ladderView = new StringBuilder();
        int height = ladder.getHeight();
        for (int i = 0; i < height; i++) {
            ladderView.append(makeLineView(ladder, i));
        }
        System.out.print(ladderView);
    }

    private static StringBuilder makeLineView(Ladder ladder, int index) {
        StringBuilder lineView = new StringBuilder();
        List<String> scaffoldsView = new ArrayList<>();

        for (Boolean scaffold : ladder.getLine(index).getScaffolds()) {
            scaffoldsView.add(makeScaffoldView(scaffold));
        }
        lineView.append(String.join("|", scaffoldsView).substring(3));
        lineView.append("\n");
        return lineView;
    }

    private static String makeScaffoldView(Boolean scaffold) {
        return scaffold ? "------" : "      ";
    }

    public static void outputLadderGameResult(String name, LadderGameResult ladderGameResult) {
        System.out.println("실행 결과");
        if ("all".equals(name)) {
            outputAllResult(ladderGameResult.allResult());
            return;
        }
        System.out.println(ladderGameResult.result(name).getName());
    }

    private static void outputAllResult(Map<Player, Reward> results) {
        StringBuilder outputResult = new StringBuilder();
        for (Player player : results.keySet()) {
            outputResult.append(player.getName())
                    .append(" : ")
                    .append(results.get(player).getName())
                    .append('\n');
        }
        System.out.print(outputResult);
    }

    public static void outputErrorMessage(String message) {
        if (message == null) {
            message = "에러가 발생했습니다.";
        }
        System.err.println(message);
    }
}
